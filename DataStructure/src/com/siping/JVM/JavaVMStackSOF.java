package com.siping.JVM;

/**
 * 虚拟机栈和本地方法栈溢出(-Xss128k)
 * 由于在HotSpot虚拟机中并不区分虚拟机栈和本地方法栈，因此，对于HotSpot来说，虽然-Xoss(设置本地方法栈大小)
 * 存在，但实际是无效的，栈容量只有-Xss参数设定。
 * @author siping-yx
 * @date 2017年12月4日
 * @version 1.0
 *
 */  
public class JavaVMStackSOF {

    private int stackLength = 1;
    private void stackLeak() {
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : " + oom.stackLength);
            throw e;
        }
    }
}
