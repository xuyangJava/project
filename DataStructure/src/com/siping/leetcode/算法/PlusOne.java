package com.siping.leetcode.算法;

import org.junit.Test;

/**
 * 66. 加一
 */
public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0; // 进位
        int a = digits[len-1] + 1;
        if(a > 9) {
            digits[len-1] = a % 10;
            carry = 1;
            for(int i = len-2; i >= 0; i-- ) {
                int j = digits[i];
                int k = j + carry;
                if(k > 9) {
                    digits[i] = k % 10;
                    carry = 1;
                }else {
                    digits[i] = k;
                    carry = 0;
                    break;
                }
            }
            if(carry == 1) {
                int[] res = new int[len + 1];
                System.arraycopy(digits, 0, res, 1, len);
                res[0] = 1;
                return res;
            }
        }else {
            digits[len-1] = a;
        }
        return digits;
    }
    
    @Test
    public void test() {
        int[] digits = {9,9};
        int[] plusOne = plusOne(digits);
        for (int i = 0; i < plusOne.length; i++) {
            System.out.println(plusOne[i]);
        }
    }
}
