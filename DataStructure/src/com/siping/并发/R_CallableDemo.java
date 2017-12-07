package com.siping.并发;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 获取线程执行返回结果
 * @author siping-yx
 * @date 2017年11月10日
 * @version 1.0
 *
 */
public class R_CallableDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new R_TaskWithResult(i)));
        }
        
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            } finally{
                exec.shutdown();
            }
        }
    }
}
