package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü
 * ¡­ ¡Ü ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
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
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return null;
		}
		
		quickSort(candidates, 0, candidates.length-1);
		
		HashSet<Integer> hSet = new HashSet<Integer>();
		for (int i : candidates) {
			if (i <= target) {
				hSet.add(i);
			}
		}
		
		List<List<Integer>> resLists = new ArrayList<List<Integer>>();
	}
}