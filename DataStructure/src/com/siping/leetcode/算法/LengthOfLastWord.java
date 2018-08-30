package com.siping.leetcode.算法;

/**
 * 最后一个单词的长度
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        int index = trim.lastIndexOf(" ");
        return index == -1 ? trim.length() : trim.length() - index - 1;
    }
}
