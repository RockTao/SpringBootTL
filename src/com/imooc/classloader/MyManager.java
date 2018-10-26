package com.imooc.classloader;


/**BaseManager 的子类，此类需要实现java类的热加载功能
 * 
 * @author Tao-Three
 *
 */
public class MyManager implements BaseManager {

	@Override
	public void logic() {
		System.out.println("我在慕课网学习了-----------热加载案例---------1111111");
		
		
		
		System.out.println("我在慕课网学习了------------热加载案例---------2222222");
	}

}
