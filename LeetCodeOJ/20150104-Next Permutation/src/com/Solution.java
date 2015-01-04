package com;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3 
 * 1,1,5 → 1,5,1
 * */

public class Solution {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 1) {
			return;
		}
		
		final int len = num.length - 1;
		int index = len;
		while (index > 0 && num[index] <= num[index - 1]) {
			index--;
		}
		
		if (index == 0) {
			quickSort(num, 0, len);
		} else {
			int temp;
			int i = len;
			while (num[i] <= num[index-1] && i >= index) {	// 注意 i 不越界
				i--;
			}
			
			temp = num[index-1];	// 注意是与哪一个数交换
			num[index-1] = num[i];
			num[i] = temp;
			quickSort(num, index, len);
		}
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