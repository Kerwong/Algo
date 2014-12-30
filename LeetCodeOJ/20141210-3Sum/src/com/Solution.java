package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of 
 * zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
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
	
	/** SOLUTION 1: brute-force, O(n^2)*/
	/*public List<List<Integer>> threeSum(int[] num) {
		quickSort(num, 0, num.length-1);
		
		
		return null;
    }*/
	
	/** SOLUTION 2: binary search*/
	
	
	/** SOLUTION 3: HashMap search*/
	/*public List<List<Integer>> threeSum(int[] num) {
		if (num == null) {
			return null;
		}
		if (num.length == 0) {
			return new ArrayList<>();
		}
		quickSort(num, 0, num.length-1);
		
		HashMap<Integer, Integer> hMap = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			if (!hMap.containsKey(num[i])) {
				hMap.put(num[i], i);
			}			
		}
		
		List<List<Integer>> resLists = null;
		
		List<Integer> iList = new ArrayList<>();
		int prevFirst = Integer.MIN_VALUE;
		int prevSecond = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == prevFirst) {
				continue;
			} else {
				prevFirst = num[i];
			}

			iList.clear();
			iList.add(num[i]);
			
			int j = i+1;
			for (; j < num.length; j++) {
				if (num[j] == prevSecond) {
					continue;
				} else {
					prevSecond = num[j];
				}
				
				if(hMap.containsKey(0 - num[i] - num[j])) {
					iList.add(num[j]);
					iList.add(0 - num[i] - num[j]);
					resLists.add(iList);
				}
			}
		}
		
		return resLists;
	}*/
	
	/** SOLUTION 4: index search
	 * 	SUCCESS! */	
	public List<List<Integer>> threeSum(int[] num) {
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
		for (int i = 0; i < num.length; i++) {
			if (num[i] == prevFirst) {
				continue;
			} else {
				prevFirst = num[i];
			}
			
			int j = i+1;
			for (; j < num.length; j++) {
				if (num[j] == prevSecond) {
					continue;
				} else {
					prevSecond = num[j];
				}
				
				for (int j2 = j+1; j2 < num.length; j2++) {
					if (num[j2] > 0 - num[i] - num[j]) {
						break;
					}
					if (num[j2] == 0 - num[i] - num[j]) {
						List<Integer> iList = new ArrayList<>();
						iList.add(num[i]);
						iList.add(num[j]);
						iList.add(0 - num[i] - num[j]);
						resLists.add(iList);
						break;
					}
				}
			}
		}
		
		return resLists;
	}
}
