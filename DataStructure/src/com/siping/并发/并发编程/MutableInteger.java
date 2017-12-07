package com.siping.并发.并发编程;

/**
 * 非线程安全，与其他问题相比失效值更容易出现：如果某个线程调用了get，另外一个线程调用set，
 * 那么正在调用get的线程可能会看到set更新后的值，也可能看不到。
 * 解决的办法是在 get和set方法都加上synchronized关键字，仅对set加仍不行，get还是可能看到失效的值,
 * @author siping-yx
 * @date 2017年11月17日
 * @version 1.0
 *
 */
public class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}

