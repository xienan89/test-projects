package com.xienan.thread;

/**
 * Created by Administrator on 2016/1/14.
 */
public class ThreadGroupTest {

    public static void main(String[] args){
        print();
        //manage();
    }

    private static void print() {
        Thread current = Thread.currentThread();

        System.out.println(current.getThreadGroup().getName());
        System.out.println(current.getThreadGroup().getParent().getName());
        System.out.println(current.getThreadGroup().getParent().getParent());
    }

    private static void manage(){
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");

                int c = Thread.currentThread().getThreadGroup().activeCount();
                System.out.println(c);
            }
        }).start();

        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");

                int c = Thread.currentThread().getThreadGroup().activeCount();
                System.out.println(c);
            }
        }).start();
    }
}
