package com.siping.并发;

public class B_LiftOff implements Runnable {
    
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    
    public B_LiftOff(){
        
    }

    public B_LiftOff(int countDown) {
        this.countDown = countDown;
    }
    
    public String status() {
        return "#" + id +"(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
    }
    
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // 线程调度器
            Thread.yield();
        }
    }
}
