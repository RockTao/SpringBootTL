package com.imooc.classloader;


/**
 * ��װ���������Ϣ
 * @author Tao-Three
 *
 */
public class LoadInfo {
	//�Զ���������
	private  MyClassLoader myLoader;
	//��¼Ҫ���ص����ʱ���---�����ص�ʱ��
	private long  loadTime;
	private BaseManager manager;
	
	public MyClassLoader getMyLoader() {
		return myLoader;
	}

	public void setMyLoader(MyClassLoader myLoader) {
		this.myLoader = myLoader;
	}

	public long getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

	public BaseManager getManager() {
		return manager;
	}

	public void setManager(BaseManager manager) {
		this.manager = manager;
	}

	public LoadInfo(MyClassLoader myLoader, long loadTime) {
		super();
		this.myLoader = myLoader;
		this.loadTime = loadTime;
	}
	


}
