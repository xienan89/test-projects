package com.xienan.lock;

/**
 * 对静态变量加锁并等同于对类加锁
 * @author nan.xie
 * @date 2014-9-12 下午2:18:19
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new RunStaticFun());
		Thread thread2 = new Thread(new RunNormalFun());
		
		thread1.start();
		Thread.sleep(500);
		thread2.start();
	}

	private static class RunStaticFun implements Runnable{

		@Override
		public void run() {
			Demo1.staticFun1();			
		}
		
	} 
	
	private static class RunNormalFun implements Runnable{

		@Override
		public void run() {
			Demo1 demo1  = new Demo1();
			demo1.fun2();
		}
		
	}
}
