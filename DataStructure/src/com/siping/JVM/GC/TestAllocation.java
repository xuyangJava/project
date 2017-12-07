package com.siping.JVM.GC;

/**
 * 对象优先在Eden中分配：-verbose:gc-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 大多数情况下，对象在新生代Eden区中分配。当Eden区没有足够空间进行分配时，虚拟机将发起一次Minor GC。
 * 在实际应用中，内存回收日志一般时打印到文件后通过日志工具进行分析的
 * -XX:PrintGCDetails(告诉虚拟机在发生垃圾收集行为时打印内存回收日志，并且在进程退出的时候输出当前的内存各区域分配情况)
 * -Xms20M -Xmx20M -Xmn10M限制了Java堆大小为20MB，不可扩展，其中10MB分配给新生代，剩下的10MB分配给老年代。
 * -XX:SurvivorRatio=8 表示新生代中Eden区与一份Survivor区的空间比例时8：1
 * @author siping-yx
 * @date 2017年12月7日
 * @version 1.0
 *
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;
    
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }
    public static void main(String[] args) {
        testAllocation();
    }
}
