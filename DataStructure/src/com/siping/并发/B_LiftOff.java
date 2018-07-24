package com.siping.并发;

import java.text.DateFormat;
import java.util.concurrent.Semaphore;

public class B_LiftOff implements Runnable {
    
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    static Semaphore semaphore = new Semaphore(3,true);
    
    public B_LiftOff(){
        
    }

    public B_LiftOff(int countDown) {
        this.countDown = countDown;
    }
    
    public void status() {
        
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"进来了");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println("#" + id +"(" + (countDown > 0 ? countDown : "Liftoff!") + "),");
        System.out.println(Thread.currentThread().getName()+"走了");
        semaphore.release();
    }
    
    @Override
    public void run() {
        while (countDown-- > 0) {
            status();
            // 线程调度器
            Thread.yield();
        }
    }
}
