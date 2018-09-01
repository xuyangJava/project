package com.siping.leetcode.算法.动态规划;

import org.junit.Test;

/**
 * 198	打家劫舍
 *
 */
public class Rob {

	public int rob(int[] nums) {
		int len = nums.length;
		if(len == 0) {
			return 0;
		}else if(len == 1) {
			return nums[0];
		}else if(len == 2) {
			return Math.max(nums[0], nums[1]);
		} else{
			int[] f = new int[len];
			f[0] = nums[0];
			f[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < len; i++) {
				f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
			}
			return f[len - 1];
		}
    }
	
	@Test
	public void test() {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}
}
