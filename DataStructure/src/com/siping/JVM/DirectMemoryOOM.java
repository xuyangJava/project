package com.siping.JVM;

/**
 * 本机直接内存溢出（-Xmx20M -XX:MaxDirectMemorySize=10M）
 * DirectMemory容量可通过-XX:MaxDirectMemorySize制定，如果不指定，则默认与Java堆
 * 最大值（-Xmx指定）一样
 * @author siping-yx
 * @date 2017年12月5日
 * @version 1.0
 *
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args) {
        /*Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);*/
        
    }
}
