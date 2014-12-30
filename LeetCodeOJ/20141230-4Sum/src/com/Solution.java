package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such 
 * that a + b + c + d = target? Find all unique quadruplets in the array which 
 * gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
 * (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * */

public class Solution {
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
	
	/** SOLUTION 1: index search
	 * 	SUCCESS! */	
	public List<List<Integer>> fourSum(int[] num, int target) {
		if (num == null) {
			return null;
		}
		if (num.length == 0) {
			return new ArrayList<>();
		}
		quickSort(num, 0, num.length-1);
		
		List<List<Integer>> resLists = new ArrayList<>();
		HashSet<List<Integer>> hMap = new HashSet<>();
		
		for (int i1 = 0; i1 < num.length - 3; i1++) {

			int i2 = i1+1;
			for (; i2 < num.length - 2; i2++) {
				
				int i3 = i2+1;
				int i4 = num.length - 1;
				while (i3 < i4) {
					int sum = num[i1] + num[i2] + num[i3] + num[i4];
					if (sum > target) {
						i4--;
						continue;
					}
					if (sum < target) {
						i3++;
						continue;
					}
					if (sum == target) {
						List<Integer> iList = new ArrayList<>();
						iList.add(num[i1]);
						iList.add(num[i2]);
						iList.add(num[i3]);
						iList.add(num[i4]);
						// 需要判断是否重复
						if (!hMap.contains(iList)) {
							hMap.add(iList);
							resLists.add(iList);
						}
						// 注意退出循环条件
						i3++;
						i4--;
					}
				}
			}
		}
		
		return resLists;
	}
	
	/* FAILED: Time Limit Exceeded*/
	/*public List<List<Integer>> fourSum(int[] num, int target) {
		if (num == null) {
			return null;
		}
		if (num.length == 0) {
			return new ArrayList<>();
		}
		quickSort(num, 0, num.length-1);
		
		List<List<Integer>> resLists = new ArrayList<>();
		
		int prevFirst = Integer.MIN_VALUE;
		int prevSecond = Integer.MIN_VALUE;
		int prevThird = Integer.MIN_VALUE;
		for (int i1 = 0; i1 < num.length - 3; i1++) {
			if (num[i1] == prevFirst) {
				continue;
			} else {
				prevFirst = num[i1];
			}
			
			int i2 = i1+1;
			for (; i2 < num.length - 2; i2++) {
				if (num[i2] == prevSecond) {
					continue;
				} else {
					prevSecond = num[i2];
				}
				
				for (int i3 = i2+1; i3 < num.length - 1; i3++) {
					if (num[i3] == prevThird) {
						continue;
					} else {
						prevThird = num[i3];
					}
					
					for (int i4 = i3+1; i4 < num.length; i4++) {
						if (num[i4] > target - num[i1] - num[i2] - num[i3]) {
							break;
						}
						if (num[i4] == target - num[i1] - num[i2] - num[i3]) {
							List<Integer> iList = new ArrayList<>();
							iList.add(num[i1]);
							iList.add(num[i2]);
							iList.add(num[i3]);
							iList.add(num[i4]);
							resLists.add(iList);
							break;
						}
					}					
				}
			}
		}
		
		return resLists;
	}*/
}
