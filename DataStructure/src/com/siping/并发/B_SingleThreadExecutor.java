package com.siping.并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_SingleThreadExecutor {

    /**
     * SingleThreadExecutor 如果提交了多个任务，那么这些任务会排队，每个任务结束后才执行下一个任务
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new B_LiftOff());
        }
        exec.shutdown();
    }
}
