package com.siping.leetcode.算法.动态规划;

/**
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 */
public class NumArray {
    
    int[] numsSum;
    public NumArray(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return;
        }
        numsSum = new int[len + 1];
        numsSum[0] = 0;
        int lastAdd = nums[0];
        numsSum[1] = lastAdd;
        for (int i = 1; i < len; i++) {
            lastAdd += nums[i];
            numsSum[i + 1] = lastAdd;
        }
    }
    
    public int sumRange(int i, int j) {
        return numsSum[j + 1] - numsSum[i];
    }
    public static void main(String[] args) {
        int[] ns = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(ns);
        System.out.println(na.sumRange(2, 5));
    }
}
