package com.xienan.thread;



/**
 * @author nan.xie
 * @date 2014-8-4 上午11:20:20
 */
public class InterruptTest {
	private static class Mythread extends Thread{
		@Override
		public void run() {
			System.out.println("thread start...");
			//sleep(10000);
			int sum = 0;
			for (int i = 0; i < 100000000; i++) {
				int j = i * 123 / 2352 % 234;
				sum += j;
			}
			System.out.println(sum);
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sleep over...");
		}
	} 

	public static void main(String[] args) {
		Thread thread = new Mythread();
		thread.start();
		thread.interrupt();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
