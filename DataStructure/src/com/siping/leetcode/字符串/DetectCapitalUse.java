package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 520.检测大写字母
 */
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char[] cs = word.toCharArray();
        if (cs[0] >= 97 && cs[0] <= 122) { // 首字母小写
            for (int i = 1; i < cs.length; i++) {
                if (cs[i] >= 65 && cs[i] <= 90) {
                    return false;
                }
            }
        } else {
            if (cs[1] >= 97 && cs[1] <= 122) { // 第二个字母小写
                for (int i = 2; i < cs.length; i++) {
                    if (cs[i] >= 65 && cs[i] <= 90) {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < cs.length; i++) {
                    if (cs[i] >= 97 && cs[i] <= 122) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                count++;
            }
        }
        if (count == word.length() || count == 0) {
            return true;
        }
        if (count == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(detectCapitalUse("Adfsds"));
    }
}
