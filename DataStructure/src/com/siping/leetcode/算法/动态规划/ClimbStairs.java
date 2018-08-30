package com.siping.leetcode.算法.动态规划;

import java.util.Map;

import org.junit.Test;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class ClimbStairs {

    /**
     * 1.简单递归复杂度为O(2^n)
     * f(n)=f(n-1)+f(n-2);
     */
    public int climbStairs1(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
    
    /**
     * 2.增加备忘录，时间复杂度和空间复杂度都为n，容易造成内存溢出
     */
    public int climbStairs2(int n, Map<Integer, Integer> map) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(map.containsKey(Integer.valueOf(n))) {
            return map.get(Integer.valueOf(n));
        }else {
            int r = climbStairs2(n - 1, map) + climbStairs2(n - 2, map);
            map.put(Integer.valueOf(n), r);
            return r;
        }
    }
    
    /**
     * 3.动态规划，时间复杂度为O(n)，空间复杂度为O(1)
     */
    public int climbStairs3(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int a = 1, b = 2, r = 0;
        for (int i = 3; i <= n; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }
    
    @Test
    public void test() {
        long start = System.currentTimeMillis();
        //System.out.println(climbStairs1(50));
        long end1 = System.currentTimeMillis();
        //System.out.println(climbStairs2(5000, new HashMap<Integer, Integer>()));
        long end2 = System.currentTimeMillis();
        System.out.println(climbStairs3(5));
        long end3 = System.currentTimeMillis();
        System.out.println("方法一花费时间：" + (end1 - start) + ",方法二花费时间：" + (end2 - end1) + ",方法二花费时间：" + (end3 - end2) );
    }
}
