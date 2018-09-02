package com.siping.leetcode.算法.动态规划;

import org.junit.Test;

/**
 * 338. 比特位计数
 * @author Administrator
 *
 */
public class CountBits {

	public int[] countBits(int num) {
		int[] a = new int[num + 1];
		a[0] = 0;
		for (int i = 1; i <= num; i++) {
			a[i] =a[i >> 1] + i % 2;
		} 
		return a;
	}
	@Test
	public void test() {
		countBits(5);
	}
}
