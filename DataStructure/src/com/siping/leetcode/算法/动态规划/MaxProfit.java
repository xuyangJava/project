package com.siping.leetcode.算法.动态规划;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格
 * = 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int buy = prices[0], max = 0;
        for (int i = 1; i < len; i++) {
            int cur = prices[i];
            if (buy > cur) {
                buy = cur;
            } else {
                int p = cur - buy;
                if (p > max) {
                    max = p;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(prices));
    }
}
