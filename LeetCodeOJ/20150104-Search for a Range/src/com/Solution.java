package com;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * */

public class Solution {
	/** SOLUTION 1: ACCEPTED
	 * 仍然可以改进，例如通过二分，直接找出 fromIndex 与 toIndex*/
	public int[] searchRange(int[] A, int target) {
		
		int mid = findByBinary(A, target, 0, A.length-1);
		if (mid == -1) {
			return new int[]{-1,-1};
		}
		
		int fromIndex = mid;
		int toIndex = mid;
		while (fromIndex >= 0 && A[fromIndex] == target) {
			fromIndex--;
		}
		fromIndex++;
		while (toIndex <= A.length-1 && A[toIndex] == target) {
			toIndex++;
		}
		toIndex--;
		
		int[] ret = new int[2];
		ret[0] = fromIndex;
		ret[1] = toIndex;
		return ret;
	}
	
	private int findByBinary(int[] num, int target, int left, int right) {
		if (left == right) {
			return num[left] == target ? left : -1;
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