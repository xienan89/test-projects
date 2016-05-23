package com.renren.xienan.thread.exit;

import org.junit.Test;

/**
 * Created by Administrator on 2016/1/16.
 */
public class ThreadGroupExceptionHandler {

    @Test
    public void mainGroup() throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("I catch a exception from  " + Thread.currentThread().getName() + ":" + Thread.currentThread().getThreadGroup().getName());
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " said my thread group is " + Thread.currentThread().getThreadGroup().getName());
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         System.out.println(Thread.currentThread().getName() + " said my thread group is " + Thread.currentThread().getThreadGroup().getName());
                         int i = 1/0;
                     }
                 }, "thread2").start();
            }
        }, "thread1").start();

        Thread.sleep(10);
    }

    @Test
    public void defaultWay(){
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("I catch a exception from  " + Thread.currentThread().getName() + ":" + Thread.currentThread().getThreadGroup().getName());
            }
        });

        ThreadGroup myGroup = new ThreadGroup("myGroup");
        new Thread(myGroup, new Runnable() {
                    @Override
                    public void run() {
                        int i = 1/0;
                    }
                }, "thread1").start();

        new Thread(myGroup, new Runnable() {
            @Override
            public void run() {
                int i = 1/0;
            }
        }, "thread2").start();

    }

    class BadGroup extends ThreadGroup{
        public BadGroup(String name) {
            super(name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("I am a bad group and do nothing");
        }
    }
    @Test
    public void badGroup(){
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("I catch a exception from  " + Thread.currentThread().getName() + ":" + Thread.currentThread().getThreadGroup().getName());
            }
        });

        BadGroup myGroup = new BadGroup("myGroup");
        new Thread(myGroup, new Runnable() {
            @Override
            public void run() {
                int i = 1/0;
            }
        }, "thread1").start();

        new Thread(myGroup, new Runnable() {
            @Override
            public void run() {
                int i = 1/0;
            }
        }, "thread2").start();

    }
}
