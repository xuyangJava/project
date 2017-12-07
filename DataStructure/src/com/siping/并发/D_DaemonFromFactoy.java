package com.siping.并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class D_DaemonFromFactoy implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted ");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        // 使用自定义ThreadFactory创建线程,这里自定义了一个守护线程
        ExecutorService exec = Executors.newCachedThreadPool(new D_DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new D_DaemonFromFactoy());
        }
        System.out.println("All daemons started!");
        TimeUnit.MILLISECONDS.sleep(500);
    }

}
