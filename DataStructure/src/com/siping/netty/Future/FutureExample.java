package com.siping.netty.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步示例二，使用Future
 * @author siping-yx
 * @date 2018年7月30日
 * @version 1.0
 *
 */
public class FutureExample {
 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I m task1 ...");
            }
        };
        
        Callable<Integer> task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Integer(100);
            }
        };
        
        Future<?> f1 = exec.submit(task1);
        Future<Integer> f2 = exec.submit(task2);
        System.out.println("task1 is completed?" + f1.isDone());
        System.out.println("task2 is completed?" + f2.isDone());
        while (f1.isDone()) {
            System.out.println("task1 is completed!");
            break;
        }
        while (f2.isDone()) {
            // Callable接口支持返回执行结果，此时需要调用FutureTask.get()方法实现，此方法会阻塞主线程直到获取‘将来’结果；当不调用此方法时，主线程不会阻塞！
            System.out.println("task2 is completed!" + f2.get());
            break;
        }
    }
}
