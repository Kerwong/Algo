package com;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * */

public class Solution {

	/***
	 * SOLUTION 1
	 */
	/*
	 * public int strStr(String haystack, String needle) { return
	 * haystack.indexOf(needle); }
	 */

	/**
	 * SOLUTION 2
	 * FAILED, Time Limit Exceeded
	 * Last executed input:	"", ""
	 * */
	/*public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}
		int offset = 0;
		int sourceLength = haystack.length();
		int targetLength = needle.length();

		if (sourceLength == targetLength && sourceLength == 0) {
			return 0;
		}

		for (; offset < sourceLength; offset++) {
			int j = 0;
			
			for (; j < targetLength && offset + j < sourceLength; j++) {
				if (haystack.charAt(offset + j) != needle.charAt(j)) {
					break;
				}
			}

			if (j == targetLength) {
				return offset;
			}
		}

		return -1;
	}*/

	/**
	 * SOLUTION 3: KMP
	 * */
	public int strStr(String haystack, String needle) { 
		
	}
}
