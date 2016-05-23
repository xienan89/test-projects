package com.xienan.thread.exit;



/**
 * @author nan.xie
 * @date 2014-9-3 下午4:47:53
 */
public class UncaughtException {
	
	public static void main(String[] args) throws InterruptedException {				
		
		Thread t = new Thread(new UncaughtException.Run());
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("uncaughtExceptionHandler catch a Exception---------");
				System.out.println(e.getMessage());
			}
		});
		
		t.start();
		Thread.sleep(100);
	}

	static class Run implements Runnable{
		@Override
		public void run() {
			Thread.currentThread().setUncaughtExceptionHandler(null);
			System.out.println("runnable run---------------");		
			int i = 1/0;
		}
	}
}
