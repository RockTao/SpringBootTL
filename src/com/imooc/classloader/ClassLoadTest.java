package com.imooc.classloader;


/**
 * ����java����ȼ���
 * @author Tao-Three
 *
 */
public class ClassLoadTest {
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();;
	}
}
