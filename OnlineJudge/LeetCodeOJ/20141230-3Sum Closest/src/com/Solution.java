package com;

import java.util.ArrayList;


/**
 * Given an array S of n integers, find three integers in S such that the sum 
 * is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */

public class Solution {	
	
	/** SOLUTION 1: Time Limit Exceeded*/
	/*public int threeSumClosest(int[] num, int target) {
		quickSort(num, 0, num.length-1);
		
		int ret = Integer.MAX_VALUE;
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			
			for (int j = i+1; j < num.length; j++) {
				
				for (int j2 = j+1; j2 < num.length; j2++) {
					int sum = num[i] + num[j] + num[j2];
					if (Math.abs(sum-target) > minDistance) {
						continue;
					} else {
						minDistance = Math.abs(sum-target);
						ret = sum;
					}
				}
			}
		}
		
		return ret;
    }
	*/
	
	public int threeSumClosest(int[] num, int target) {
		quickSort(num, 0, num.length-1);
		
		int ret = Integer.MAX_VALUE;
		int minDistance = Integer.MAX_VALUE;
		
		int prevFirst = Integer.MIN_VALUE;
		int prevSecond = Integer.MIN_VALUE;
		for (int i = 0; i < num.length-2; i++) {
			if (num[i] == prevFirst) {
				continue;
			} else {
				prevFirst = num[i];
			}
				
			for (int j = i+1; j < num.length-1; j++) {
				if (num[j] == prevSecond) {
					continue;
				} else {
					prevSecond = num[i];
				}
				
				for (int j2 = j+1; j2 < num.length; j2++) {
					int sum = num[i] + num[j] + num[j2];
					if (minDistance > Math.abs(sum-target)) {
						minDistance = Math.abs(sum-target);
						ret = sum;
					}
					if (sum-target > 0) {
						break;
					}
				}
			}
		}
		
		return ret;
    }
	
	private void quickSort(int[] num, int start, int end) {
		int left = start;
		int right = end;
		
		int tmp = num[left];
		while (left < right) {
			while (left < right && num[right] >= tmp) {
				right--;
			}
			
			if (left < right) {
				num[left] = num[right];
			}
			
			while (left < right && num[left] <= tmp) {
				left++;
			}
			
			if (left < right) {
				num[right] = num[left];
			}
		}
		
		num[left] = tmp;
		
		if (left - 1 > start) {
			quickSort(num, start, left-1);
		}
		if (left + 1 < end) {
			quickSort(num, left+1, end);
		}
	}
}
