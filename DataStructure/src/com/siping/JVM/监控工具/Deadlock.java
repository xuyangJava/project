package com.siping.JVM.监控工具;

/**
 * 模拟死锁发生，使用jconsole进行查看
 * 这段代码开了200个线程去分别计算1+2以及2+1的值，其实for循环时可以省略的，两个线程
 * 也可能会导致死锁，不过概率比较小，需要尝试多次。
 * 造成死锁的原因是Integer.calueOf()方法基于减少对象创建次数和节省内存的考虑，[-128, 127]
 * 之间的数字会被缓存，当valueOf()方法传入参数在这个范围之内，将直接返回缓存中的对象。也就是说，代码
 * 中调用了200次Integer.valueOf()方法一共就只返回了两个不同的对象。例如在某个线程两个synchronized
 * 块之间发生一次线程，那就回出现线程A等着被线程B持有的Integer.valueOf(1),线程B又等着被线程A持有的
 * Integer.valueOf(2),结果出现大家都跑不下去的情景。
 * @author siping-yx
 * @date 2017年12月7日
 * @version 1.0
 *
 */
public class Deadlock {

    static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunable(1, 2)).start();
            new Thread(new SynAddRunable(2, 1)).start();
        }
    }
}
