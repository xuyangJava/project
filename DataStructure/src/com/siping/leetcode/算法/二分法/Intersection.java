package com.siping.leetcode.算法.二分法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * 349.两个数组的交集
 * @author Administrator
 *
 */
public class Intersection {

	public int[] intersection(int[] nums1, int[] nums2) {
		
		int len1 = nums1.length;
		int len2 = nums2.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
				
		Set<Integer> s = new HashSet<>();
		
		int p1 = 0; // 数组1的指针
		int p2 = 0; // 数组2的指针
		while(p1 < len1 && p2 < len2) {
			if(nums1[p1] < nums2[p2]) {
				p1++;
			} else if(nums1[p1] > nums2[p2]) {
				p2++;
			}else if(nums1[p1] == nums2[p2]) {
				s.add(nums1[p1]);
				p1++;
				p2++;
			}
		}
		int[] res = new int[s.size()];
		Iterator<Integer> it = s.iterator();
		int i = 0;
		while (it.hasNext()) {
			res[i] = it.next();
			i++;
		}
		return res;
	}
	
	@Test
	public void test() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		intersection(nums1, nums2);
	}
}
