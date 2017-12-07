package com.siping.JVM.监控工具;

import java.util.ArrayList;
import java.util.List;
/**
 * jconsole监控工具的使用
 * @author siping-yx
 * @date 2017年12月7日
 * @version 1.0
 *
 */
public class TestJconsole {
 
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50); // 延迟，监视曲线变化
            list.add(new OOMObject());
        }
        System.gc();
    }
    
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
