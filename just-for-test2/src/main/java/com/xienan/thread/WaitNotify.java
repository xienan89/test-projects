package com.xienan.thread;

/**
 * Created by Administrator on 2016/1/16.
 */
public class WaitNotify {
    private volatile static boolean canStart = false;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (!canStart) {
                        try {
                            System.out.println("start loop...");
                            lock.wait();
                            System.out.println("run...");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("end loop...");
                    }
                }
            }
        });

        thread.start();

        Thread.sleep(10);
        synchronized (lock){
            thread.interrupt();
            Thread.sleep(5000);
        }

       /* canStart = true;
        synchronized (lock){
            lock.notify();
        }*/
    }
}
