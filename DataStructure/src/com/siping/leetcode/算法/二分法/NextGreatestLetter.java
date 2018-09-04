package com.siping.leetcode.算法.二分法;

import org.junit.Test;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length, left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < len ? letters[left] : letters[0];
    }

    @Test
    public void test() {
        char[] letters = { 'c', 'f', 'j' };
        System.out.println(nextGreatestLetter(letters, 'j'));
    }
}
