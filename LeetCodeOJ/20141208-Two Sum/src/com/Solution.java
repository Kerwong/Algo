package com;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. You may assume that each input would have exactly one
 * solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * */

public class Solution {
	public int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			int j = numbers[i];
			hMap.put(j, i);
		}

		int[] res = new int[2];
		Integer ret = 0;
		for (int i = 0; i < numbers.length; i++) {
			ret = hMap.get(target - numbers[i]);
			if (null != ret) {
				if (ret > i) {
					/* WARNING: numbers={2, 7, 11, 15}, target=9 
					 * Output: index1=1, index2=2, !NOT index1=0, index2=1
					 * so, need to plus 1 */
					res[0] = i+1;
					res[1] = ret+1;
				} else if (ret < i) {
					res[0] = ret+1;
					res[1] = i+1;
				} else {
					/* WARNING��index1 must be less than index2
					 * int[] numbers = {3,2,4}, target = 6, 
					 * index1 = index2 = 1 */
					continue;
				}				
				return res;
			}
		}
		return null;
	}
}
