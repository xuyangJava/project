package com.siping.并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_CachedThreadPool {

    public static void main(String[] args) {
        // CachedThreadPool会创建与所需数量相同的线程，然后在它回收旧线程时停止创建新线程，因此他是创建线程的优先选择
        // 只有当这种方式发生问题时才考虑使用FixedThreadPool，使用固定数量的线程，可以节约创建线程的开销
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new B_LiftOff());
        }
        exec.shutdown();
    }
}
