package com.siping.JVM;
/**
 * 创建线程导致内存溢出异常(-Xss2M)
 * 在windows平台的虚拟机中，Java的线程是映射到操作系统的内核线程上的，因此该
 * 代码执行时有较大的风险，可能会导致操作系统假死
 * @author siping-yx
 * @date 2017年12月5日
 * @version 1.0
 *
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
            
        }
    }
    
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                
                @Override
                public void run() {
                   dontStop();
                }
            });
            
            thread.start();
        }
    }
    
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
