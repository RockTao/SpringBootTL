package com.imooc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器来实现Java类的加载
 * @author Tao-Three
 *
 */
public class MyClassLoader extends ClassLoader {
	//需加载的java类的claspath路径
	private String classpath;


	public MyClassLoader(String classpath) {
		super(ClassLoader.getSystemClassLoader());
		this.classpath = classpath;
	}


	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//		return super.findClass(name);
		byte[] data=this.loadClassData(name);
		return this.defineClass(name, data, 0,name.length());

	}

	/*
	 * 加载class文件中的内容
	 */
	private byte[] loadClassData(String name) {
		try {
			name=name.replace(".", "//");
			FileInputStream is= new FileInputStream(new File(classpath+name+".class"));
			ByteArrayOutputStream baos =new ByteArrayOutputStream();
			int b = 0 ;
			while((b = is.read())!=-1) {
				baos.write(b);
			}
			is.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
