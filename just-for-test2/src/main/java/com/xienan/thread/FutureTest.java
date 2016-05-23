/**
 * 
 */
package com.xienan.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author nan.xie
 * @date 2014-5-28 下午5:50:50
 */
public class FutureTest {

	static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) throws ExecutionException {
		Future<String> future1 = THREAD_POOL.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					System.out.println("future1 start...");
					try {
						List<Integer> list = new LinkedList<Integer>();
						for (int i = 0; i < 10000; i++) {
                            list.add(i);
                        }
						for (int i = 0; i < 10000; i++) {
                            list.set(i, i + 1);
							if (i == 9999){
								System.out.println("if future1 interrupted: " + Thread.currentThread().isInterrupted());
							}
                        }
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("I am nb 1");
					return "call_1";
				}
			});
			
		Future<String> future2 = THREAD_POOL.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					System.out.println("future2 start...");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						System.out.println("I can response interrupt");
					}
					System.out.println("I am nb 2");
					return "call_2";
				}
			});

		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		future1.cancel(true);
		future2.cancel(true);
	}

}
