package com.siping.leetcode.算法;

import org.junit.Test;

/**
 * 是否是回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int y = x;
        int reverseX = 0;
        while(x != 0) {
            int tmp = reverseX * 10 + x % 10;
            if(tmp / 10 != reverseX) {
                return false;
            }
            reverseX = tmp;
            x = x / 10;
        }
        if(reverseX == y) {
            return true;
        }else{
            return false;
        }
    }
    @Test
    public void test() {
        System.out.println(isPalindrome(121));
    }
}
