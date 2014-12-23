package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element 
 * always exist in the array.
 */

public class Solution {
	/** SOLUTION 1: SUCCESS*/
	/*
	public int majorityElement(int[] num) {
        
		int len = num.length;
		
		HashMap<Integer, Integer> eleMap = new HashMap<>();
		
		for (int i = 0; i < len; i++) {
			if (eleMap.containsKey(num[i])) {
				int val = eleMap.get(num[i]) + 1;
				eleMap.put(num[i], val);
			} else {
				eleMap.put(num[i], 1);
			}
		}

		Set<Integer> keySet = eleMap.keySet();
		for (Integer integer : keySet) {
			if (eleMap.get(integer) > len/2) {
				return integer;
			}
		}
		
		return -1;
    }
    */
	
	public int majorityElement(int[] num) {
		int len = num.length-1;
		quickSort(num, 0, len);
		return num[len/2];
	}
	
	private void quickSort(int[] num, int start, int end) {
		int i = start;
		int j = end;
		
		int temp = num[i];
		while (i < j) {
			while (i < j && num[j] >= temp) 
				j--;
			
			if (i < j) {
				num[i] = num[j];
			}
			
			while (i < j && num[i] <= temp ) {
				i++;
			}
			
			if (i < j) {
				num[j] = num[i];
			}			
		}
		
		num[i] = temp;
		
		if (i > start+1) {
			quickSort(num, start, i-1);
		}
		if (i < end-1) {
			quickSort(num, i+1, end);
		}
	}
}