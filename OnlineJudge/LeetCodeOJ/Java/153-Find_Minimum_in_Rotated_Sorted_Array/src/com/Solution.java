package com;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

public class Solution {
	/** SOLUTION 1 */
	public int findMin(int[] num) {
		if (num.length == 1) {
			return num[0];
		}
		
		return findMinByBinary(num, 0, num.length-1);
    }
	
	private int findMinByBinary(int[] num, int left, int right) {
		if (left == right) {
			return num[left];
		}
		
		if (left == right-1) {
			return Math.min(num[left], num[right]);
		}
		
		int mid = (left + right) / 2;
		if (num[right] > num[mid]) {
			return findMinByBinary(num, left, mid);
		} else {
			return findMinByBinary(num, mid, right);
		} 
	}
}