package com.siping.leetcode.算法.动态规划;

import org.junit.Test;

/**
 * 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * [-2,1,-3,4,-1,2,1,-5,4,3]
 */
public class MaxSubArray {

    // TODO 使用分治法解决
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0]; // 最大值
        int curSum = nums[0]; // 本轮之和
        
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if(curSum < 0) { // 本轮相加如果小于0
                if(cur > curSum) {
                    curSum = cur;
                }
            }else {
                curSum += cur;
            }
            if(max < curSum) {
                max = curSum;
            }
        }
        return max;
    }
    
    @Test
    public void test() {
        MaxSubArray msa = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4,3};
        System.out.println(msa.maxSubArray(nums));
    }
}
