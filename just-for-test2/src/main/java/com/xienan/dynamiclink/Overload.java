package com.xienan.dynamiclink;

/**
 * @author nan.xie
 * @date 2014-11-17 下午7:09:24
 */
public class Overload {
	static interface Interman{}
	static abstract class Human{
		int i = 0;
		public static void fun(){
			System.out.println("human static fun");
		}
	}
	static class Man extends Human implements Interman{
		int i = 1;
	}
	static class Women extends Human{
		public static void fun(){
			System.out.println("woman static fun");
		}
	};
	
	static void hello(Human human){
		System.out.println("hello human");
	}
	
	static void hello(Interman interman){
		System.out.println("hello interman");
	}
	
	static void hello(Man man){
		System.out.println("hello man");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human human = new Man();
		Man man = new Man();
		Human women = new Women();
		hello(human);
		hello(man);
		Human.fun();
		women.fun();

        /**
         * 结果0. man对象其实有两个i变量，用human访问得到父类中的i变量值。在man对象中只能看见子类的i。
         */
		System.out.println(human.i);
	}

}
