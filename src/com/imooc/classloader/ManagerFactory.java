package com.imooc.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * ����manager�Ĺ���
 * @author Tao-Three
 *
 */
public class ManagerFactory {
	//��¼�ȼ�����ļ�����Ϣ
	private  static final Map<String,LoadInfo> loadTimeMap=new HashMap<String,LoadInfo>();
	//Ҫ���ص����classpath
	public static final String CLASS_PATH="D:/Work/springBoot/classLoader/bin";
	//ʵ���ȼ������ȫ����  ����  +����  
	public static final String MY_MANAGER="com.imooc.classloader.MyManager";

	public static BaseManager getManager(String className) {
		File loadFile = new File(CLASS_PATH + MY_MANAGER.replace("\\.", "/") +".class");
		long lastModified=loadFile.lastModified();
		//loadTimeMap������classNameΪkey��LoadInfo��Ϣ��֤�������û�б����أ���ô��Ҫ��������ൽjvm
		if(loadTimeMap.get(className)== null) {
			load(className,lastModified);
		}//�������ʱ����仯�ˣ�����ͬ����Ҫ���¼�������ൽjvm
		else if(loadTimeMap.get(className).getLoadTime()!=lastModified) {
			load(className,lastModified);
		}

		return loadTimeMap.get(className).getManager();
	}

	private static void load(String className, long lastModified) {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = null;
		try {
			loadClass=myClassLoader.loadClass(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseManager manager=newInstance(loadClass);
		LoadInfo loadInfo= new LoadInfo(myClassLoader, lastModified);
		loadInfo.setManager(manager);
		loadTimeMap.put(className,loadInfo);
	}
	//�ѷ���ķ�ʽ����BaseManager����Ķ���
	private static BaseManager newInstance(Class<?> loadClass) {
		try {
			return (BaseManager) loadClass.getConstructor(new Class[] {})
					.newInstance(new Object[] {});
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

