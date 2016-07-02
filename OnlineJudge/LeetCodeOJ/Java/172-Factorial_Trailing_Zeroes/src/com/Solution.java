package com;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * */

public class Solution {
	public int trailingZeroes(int n) {
		
		int divisor = 1;

		while (n/divisor > 4) {		// 注意结束条件
			divisor = divisor * 5;
		}
		
		int result = 0;
		for (; divisor != 1; divisor/=5) {
			result += n/divisor;
		}
		
		return result;
	}
}