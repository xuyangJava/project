package com.siping.并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 休眠
public class B_SleepingTask extends B_LiftOff {

    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());

                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new B_SleepingTask());
        }
        exec.shutdown();
    }
}
