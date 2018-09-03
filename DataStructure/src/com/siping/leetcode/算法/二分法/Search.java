package com.siping.leetcode.算法.二分法;

import org.junit.Test;

/**
 * 704. 二分查找
 */
public class Search {

	public int search(int[] nums, int target) {
		if(target < nums[0] || target > nums[nums.length - 1]) {
			return -1;
		}
        int left = 0;
        int right = nums.length;
        
        int mid = 0;
        while (left <= right) {
        	mid = (left + right) / 2;
        	if(nums[mid] < target) {
        		left = mid + 1;
        	} else if(nums[mid] > target) {
        		right = mid - 1;
        	} else {
        		return mid;
        	}
		}
		return -1;
    }
	
	@Test
	public void test() {
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums, 9));
	}
}
