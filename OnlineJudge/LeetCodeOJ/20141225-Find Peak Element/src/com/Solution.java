package com;


/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ¡Ù num[i+1], 
 * find a peak element and return its index.
 * 
 * The array may contain multiple peaks, 
 * in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -¡Ş.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
 * should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 */

public class Solution {
	/** SOLUTION 1 */
	public int findPeakElement(int[] num) {
        return findPeakByBinary(num, 0, num.length-1);
    }
	
	private int findPeakByBinary(int[] num, int left, int right) {
		if (left == right) {
			return left;
		}
		
		int mid = (left + right) / 2;
		
		if (mid == left && num[left] > num[left+1]) {
			return left;
		}
		
		if (mid == right-1 && num[right] > num[right-1]) {
			return right;
		}
		
		if (num[mid] > num[mid-1] && num[mid] > num[mid+1]) {
			return mid;
		}
		
		if (num[mid] < num[mid-1]) {
			return findPeakByBinary(num, left, mid-1);
		} else {
			return findPeakByBinary(num, mid+1, right);
		} 
	}
}