package com.xienan.thread.exit;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2016/1/15.
 */
public class SimpleCooperation {
    private static volatile boolean stop = false;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop){
                    System.out.println("I am running " + count++);
                    for (int i = 2; i < 999999; i++) {
                        int j = i / (i-1);
                    }
                }
                System.out.println("I am stop");
            }
        }).start();

        Thread.sleep(10);
        stop = true;
    }
}
