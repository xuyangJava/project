package com.siping.并发;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程，守护线程创建的线程都是守护线程
 * @author siping-yx
 * @date 2017年11月10日
 * @version 1.0
 *
 */
public class D_SimpleDaemons implements Runnable {

    @Override
    public void run() {
       try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread daemon = new Thread(new D_SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
    
}
