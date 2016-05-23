package com.xienan.clazzload;

public class Main {

	public static void main(String[] args) {
		System.out.println("main start");
		System.out.println(ClazzLoad.class);
		System.out.println("after .class");
		ClazzLoad clazzLoad = new ClazzLoad();
		System.out.println("after instance");
	}

}
