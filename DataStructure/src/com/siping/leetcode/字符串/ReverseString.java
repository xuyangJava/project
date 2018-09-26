package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 344. 反转字符串
 */
public class ReverseString {

    /*
     *  暴力法
     */
    public String reverseString(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = cs[len - 1 - i];
        }
        return new String(res);
    }
    
    /*
     * 交换中心点两边的字符
     */
    public String reverseString2(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = cs[i];
            cs[i] = cs[len - 1 - i];
            cs[len - 1 - i] = tmp;
        }
        return new String(cs);
    }
    
    @Test
    public void test() {
        System.out.println(reverseString2("1fdsdgsd"));
    }
}
