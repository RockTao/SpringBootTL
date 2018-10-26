package com.imooc.classloader;


/**
 * ��̨����һ���̲߳���ˢ�����¼���ʵ�����˼��ص���
 * @author Tao-Three
 *
 */
public class MsgHandler implements Runnable {

	@Override
	public void run() {
		while(true) {
			BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
			manager.logic();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
