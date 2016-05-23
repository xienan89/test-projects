package com.renren.xienan.thread.exit;

import org.junit.Test;

/**
 * Created by Administrator on 2016/1/15.
 */
public class ThreadExitTest {

    @Test
    public void  daemon(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            thread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
