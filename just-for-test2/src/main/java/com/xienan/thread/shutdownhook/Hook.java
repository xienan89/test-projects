package com.xienan.thread.shutdownhook;

/**
 * Created by xienan on 2015/10/12.
 */
public class Hook {
    public static void main(String[] arg){
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("shutdown hook!!!");
            }
        }));
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
