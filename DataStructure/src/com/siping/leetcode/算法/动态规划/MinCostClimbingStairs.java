package com.siping.leetcode.算法.动态规划;

import org.junit.Test;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len <= 1) {
            return 0;
        }
        if(len == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] f = new int[len + 1];
        int fl = f.length;
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i < fl; i++) {
            f[i] = Math.min(f[i - 2] + cost[i - 2], f[i - 1] + cost[i - 1]);
            System.out.println(f[i]);
        }
        return f[len];
    }
    
    @Test
    public void test() {
        int cost[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
