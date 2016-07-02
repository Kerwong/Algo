package com;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 ¡ú 2 
 * [1,3,5,6], 2 ¡ú 1 
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * */

public class Solution {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (target > A[A.length-1]) {
			return A.length-1;
		}
		
		return findByBinary(A, target, 0, A.length-1);
	}
	
	private int findByBinary(int[] num, int target, int left, int right) {		
		if (left == right) {
			return left;
		}
		
		int mid = (left + right)/2;
		if (num[mid] == target) {
			return mid;
		} else if (num[mid] > target) {
			return findByBinary(num, target, left, mid);
		} else {
			return findByBinary(num, target, mid+1, right);
		}
	}
}