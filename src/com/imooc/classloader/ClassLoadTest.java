package com.imooc.classloader;


/**
 * 测试java类的热加载
 * @author Tao-Three
 *
 */
public class ClassLoadTest {
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();;
	}
}
