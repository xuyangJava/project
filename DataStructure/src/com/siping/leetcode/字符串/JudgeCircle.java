package com.siping.leetcode.字符串;

import org.junit.Test;

/**
 * 657. 机器人能否返回原点
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] cs = moves.toCharArray();
        for (char c : cs) {
            switch (c) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }
    
    @Test
    public void test() {
        System.out.println(judgeCircle("LR"));
    }
}
