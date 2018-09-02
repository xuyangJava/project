package com.siping.leetcode.算法.二分法;

import org.junit.Test;

/**
 * 852. 山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {
	
	public int peakIndexInMountainArray(int[] A) {
        int len = A.length, left = 0, right = len - 1, mid = 0;
        while(left < right) {
        	mid = (left + right) / 2;
        	if(A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
        		left  = mid;
        	} else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
        		right = mid;
        	} else if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			}
		}
        return -1;
    }
	
	@Test
	public void test() {
		int[] a = {3,4,5,2};
		System.out.println(peakIndexInMountainArray(a));
	}
}
