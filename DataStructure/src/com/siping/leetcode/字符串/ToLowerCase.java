package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 转换成小写字母
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] >= 65 && charArray[i] <= 90) {
                charArray[i] = (char) ((int)charArray[i] + 32);
            }
        }
        return String.valueOf(charArray);
    }
    
    @Test
    public void test() {
        System.out.println(toLowerCase("fSsgdsgd"));
    }
}
