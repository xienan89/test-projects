package com.xienan.thread.mythreadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nan.xie
 * @date 2014-9-4 上午10:23:05
 */
public class MyThreadPool {
	private static AtomicInteger atomicInteger = new AtomicInteger();
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("uncaughtException-----------");
				e.printStackTrace();
			}
		});
		
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(2); 
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2,5,1000,TimeUnit.MILLISECONDS,bqueue); 
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		
		for (int i = 0; i < 20; i++) {
			try {
				pool.execute(new Run(i));
			} catch (Exception e1) {
				System.out.println("poll execute exception, poolsize:" + pool.getPoolSize() + ", queuesize:" + pool.getQueue().size());
				e1.printStackTrace();
				Thread.sleep(2000);
			}
		}
		
		Runtime.getRuntime().exit(0);
	}
	
	static class Run implements Runnable{
		public int i;
		public Run(int atomicInteger){
			i = atomicInteger;
		}
		
		@Override
		public void run() {
			System.out.println("runnable run---------------" + i);	
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println(1/0);
		}
	}

}
