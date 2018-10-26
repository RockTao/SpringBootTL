package com.imooc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * �Զ���java���������ʵ��Java��ļ���
 * @author Tao-Three
 *
 */
public class MyClassLoader extends ClassLoader {
	//����ص�java���claspath·��
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
	 * ����class�ļ��е�����
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
