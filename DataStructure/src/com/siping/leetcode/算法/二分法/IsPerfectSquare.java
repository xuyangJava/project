package com.siping.leetcode.算法.二分法;

import org.junit.Test;

/**
 * 367. 有效的完全平方数
 * @author siping-yx
 * @date 2018年9月4日
 * @version 1.0
 */
public class IsPerfectSquare {

    /**
     * 使用二分法，事实证明比下面的方法快很多
     */
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) {
            return true;
        }
        int l = 0, r = num, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (num / mid < mid ) {
                r = mid - 1;
            } else if (num / mid > mid) {
                l = mid + 1;
            } else if (num / mid == mid && num % mid == 0) {
                return true;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    /**
     * 通过列举所有的完全平方数，1，4，9，16，25，36，49，64，81，100…等等，发现完全平方数的差都为奇数，
     * 即1，3，5，7，9，11，13，15…等等~所以可以判断完全平方数应该是N个奇数的和。
     */
    public boolean isPerfectSquare2(int num) {
        for(int i = 1; num > 0; i += 2){
            num -= i;
        }
        return num == 0;
    }
    
    @Test
    public void test() {
        System.out.println(isPerfectSquare(Integer.MAX_VALUE));

    }
}
