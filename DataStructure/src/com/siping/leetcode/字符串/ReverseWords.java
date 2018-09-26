package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 557.
反转字符串中的单词 III
 *
 */
public class ReverseWords {
    
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = reverseString(sArr[i]);
        }
        StringBuffer sb = new StringBuffer(s.length() * 4 / 3 + 1);
        for (int i = 0; i < sArr.length; i++) {
            sb.append(sArr[i]).append(" ");
        }
        
        return sb.toString().trim();
    }
    public String reverseString(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = cs[len - 1 - i];
        }
        return new String(res);
    }
    
    @Test
    public void test() {
        System.out.println(reverseWords("Hello world"));
    }
}
