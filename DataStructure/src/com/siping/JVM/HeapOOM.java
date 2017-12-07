package com.siping.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出(-Xms20M-Xmx20M-XX:+HeapDumpOnOutOfMemoryError)
 * Java堆用于存储对象实例，只要不断的创建对象，并且保证GC Roots到对象之间有可达路径
 * 来避免垃圾回收机制清除这些对象，那么在对象数量到达最大的容量限制后就会产生内存溢出异常。
 * HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前内存堆转储
 * 快照以便事后进行分析
 * @author siping-yx
 * @date 2017年12月4日
 * @version 1.0
 *
 */
public class HeapOOM {

    static class OOMObject {
        
    }
    
    public static void main(String[] args) {
        List<OOMObject> lists = new ArrayList<HeapOOM.OOMObject>();
        while (true) {
            lists.add(new OOMObject());
        }
    }
}
