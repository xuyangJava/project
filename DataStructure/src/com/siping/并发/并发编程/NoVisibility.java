package com.siping.并发.并发编程;

/**
 * 可见性和重排序
 * 
 * 该示例中，存在两个线程，读线程和主线程，都访问共享变量ready和number。主线程启动读线程，然后将number设置为42，ready设置为true，然后输入number的值。
 * 该程序的运行结果可能是42，也可能一直循环，甚至有可能是0（重排序），这是因为代码中没有足够的同步机制，因此无法保证主线程写入的ready和number的值对读线程是可见的。
 * @author siping-yx
 * @date 2017年11月17日
 * @version 1.0
 *
 */
public class NoVisibility {

    private static boolean ready;
    
    private static int number;
    
    private static class ReaderThread extends Thread {
        
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while(!ready) {
                Thread.yield();
            }
            System.out.println("number : " + number);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        System.out.println(Thread.currentThread().getName());
        number = 42;
        ready = true;
    }
}
