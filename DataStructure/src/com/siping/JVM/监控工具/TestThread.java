package com.siping.JVM.监控工具;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * jconsole监控线程
 * @author siping-yx
 * @date 2017年12月7日
 * @version 1.0
 *
 */
public class TestThread {

    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    
                }
            }
        }, "testBusyThread");
        t.start();
    }
    
    /**
     * 测试锁等待
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        t.start();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
