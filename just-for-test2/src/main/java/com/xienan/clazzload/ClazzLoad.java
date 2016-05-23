package com.xienan.clazzload;

public class ClazzLoad {
	static{
		System.out.println("static block!");
	}

	public static void main(String[] args) {
		System.out.println("main start");
		System.out.println(ClazzLoad.class);
		System.out.println("after .class");
	}

}
