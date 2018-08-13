package com.siping.leetcode.算法;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RomanToInt {
    /**
     * 罗马字母转int
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000); // CD CM
        
        char[] cs = s.toCharArray();
        int last = 0;
        int result = 0;
        for (char c : cs) {
            int v = map.get(String.valueOf(c));
            if (last == 0) {
                result = v;
            } else if (last >= v) {
                result += v;
            } else {
                result = result + v - 2*last;
            }
            last = v;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
