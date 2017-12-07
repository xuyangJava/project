package com.siping.JVM.GC;

/**
 * 引用计数算法（怎么判断对象已死--可以回收）-XX:+PrintGCDetails(打印gc日志)
 * 给对象中添加一个引用计数器，每当有一个地方引用它时，计数器值就加1；当引用失效时，计数器值就减1；
 * 任何时刻计数器为0的对象就是不可能再被使用的。
 * 但是，在主流的Java虚拟机里面没用选用引用计数算法来管理内存，其中最主要的原因时它很难解决对象之间的相互循环引用问题
 * @author siping-yx
 * @date 2017年12月5日
 * @version 1.0
 *
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /*
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];
    
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这发生GC，objA和objB是否能被回收
        System.gc();
    }
    
    public static void main(String[] args) {
        testGC();
    }
}
