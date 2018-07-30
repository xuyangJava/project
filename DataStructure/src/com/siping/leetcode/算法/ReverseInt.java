package com.siping.leetcode.算法;

import org.junit.Test;

/**
 * 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 输入: 123 输出: 321
 * 输入: -123 输出: -321
 * 输入: 120 输出: 21
 */
public class ReverseInt {

    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int tmp = result * 10 + x % 10;
            if(tmp / 10 != result) {
                return 0;
            }
            x = x / 10;
            result = tmp;
        }
        return result;
    }
    
    @Test
    public void test() {
        System.out.println(reverse(-12345640));
    }
}
