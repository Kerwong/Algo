package com;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * */

public class Solution {
	public int search(int[] A, int target) {
		int ret = findTargetByBinary(A, target, 0, A.length-1);
		return ret;
	}
	
	private int findTargetByBinary(int[] num, int target, int left, int right) {
		if (left == right) {
			return num[left] == target ? left : -1;
		}
		
		int mid = (left + right) / 2;
		if (num[mid] > num[right]) {
			if (target == num[mid]) {
				return mid;
			} else if (target > num[right] && target < num[mid]) {
				return findTargetByBinary(num, target, left, mid);
			} else {
				return findTargetByBinary(num, target, mid+1, right);
			}
		} else if (num[mid] < num[right]){
			if (target == num[mid]) {
				return mid;
			} else if (target > num[mid] && target <= num[right]) {
				return findTargetByBinary(num, target, mid+1, right);				
			} else {
				return findTargetByBinary(num, target, left, mid);
			}
		} else {
			return -1;
		}
	}
}