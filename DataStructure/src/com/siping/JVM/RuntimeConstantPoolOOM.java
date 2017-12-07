package com.siping.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池溢出（-XX:PermSize=10M -XX:MaxPermSize=10M）
 * @author siping-yx
 * @date 2017年12月5日
 * @version 1.0
 *
 */
public class RuntimeConstantPoolOOM {

    /**
     * 在JDK1.7之前运行会出现PermGen space（说明运行时常量池属于方法区--HotSpot虚拟机中的永久代）运行时常量池溢出错误，
     * 但在JDK1.7之后则不会出现相同的结果，while循环将一直循环下去。
     */
    /*public static void main(String[] args) {
        // 使用list保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM
        int i = 0;
        while (true) {
            // intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象
            // 对象的字符串，则返回代表池中这个字符串的String对象；否则此String对象包含的字符串添加到
            // 常量池中，并且返回String对象的引用
            list.add(String.valueOf(i++).intern());
        }
    }*/
    
    /**
     * 这段代码在JDK1.6中会得到两个false，而在JDK1.7中会得到一个true和一个false
     * 参看深入理解java虚拟机2.4.3 方法区和运行时常量池溢出
     * @param args
     */
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
    
}
