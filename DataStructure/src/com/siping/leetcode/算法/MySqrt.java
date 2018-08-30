package com.siping.leetcode.算法;

import org.junit.Test;

/**
 * 69. x 的平方根
 * TODO 牛犊迭代法求解
 */
public class MySqrt {

    // 二分法求解
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(x / mid >= mid) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left - 1;
    }
    
    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));
    }
}
