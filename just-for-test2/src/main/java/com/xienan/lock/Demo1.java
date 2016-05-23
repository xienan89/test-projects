package com.xienan.lock;

/**
 * @author nan.xie
 * @date 2014-9-12 下午2:15:14
 */
public class Demo1 {
	private static Integer o = new Integer(10);
	
	public static synchronized void staticFun1(){
		try {
			System.out.println("staticFun1 goto sleep at " + System.currentTimeMillis());
			System.out.println("static int " + o);
			Thread.sleep(2000);
			System.out.println("static int " + o);
			System.out.println("staticFun1 goto wake up at " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fun2(){
		try {		
			
			synchronized (o) {
				System.out.println("fun2 fix integer o");
				o += 2;
			}
			
			System.out.println("fun2 goto sleep at " + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("fun2 goto wake up at " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
