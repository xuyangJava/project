package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 771. 宝石与石头
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] charArray = S.toCharArray();
        for (char c : charArray) {
            if(J.indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }
    
    @Test
    public void test() {
        String J = "aZ";
        String S = "AZaZddfdgesd";
        System.out.println(numJewelsInStones(J, S));
    }
}
