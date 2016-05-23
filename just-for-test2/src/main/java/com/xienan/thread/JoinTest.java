package com.xienan.thread;

/**
 * @author nan.xie
 * @date 2014-9-18 上午10:50:09
 */
public class JoinTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new ThreadA());
		Thread thread2 = new Thread(new ThreadB());
		
		//thread1.start();
		thread1.join();
		System.out.println("end...");
	}

	private static class ThreadA implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ThreadA run..");			
		}
		
	}
	private static class ThreadB implements Runnable{

		@Override
		public void run() {
			System.out.println("ThreadB run..");	
		}
		
	}
}
