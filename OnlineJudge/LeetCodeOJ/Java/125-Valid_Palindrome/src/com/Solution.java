package com;


/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases. 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome. 
 * "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview. For the purpose of this problem, we
 * define empty string as valid palindrome.
 */

public class Solution {
	
	/* SOLUTION 1: FAILED
	 * Time Limit Exceeded */
	/*public boolean isPalindrome(String s) {
		String formatedStr = "";
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!Character.isAlphabetic(ch)) {
				continue;
			}
			formatedStr += Character.toLowerCase(ch); 
		}
		
		int len = formatedStr.length();
		for (int i = 0; i < len/2; i++) {
			if (formatedStr.charAt(i) != formatedStr.charAt(len-1-i)) {
				return false;
			}
		}		
		return true;
	}*/
	
	/* SOLUTION 2: 无法判断奇偶回文*/
	/*
	public boolean isPalindrome(String s) {
		int leftindex = 0;
		int rightindex = s.length()-1;
		
		for (; leftindex < rightindex; leftindex++) {
			char lchar = s.charAt(leftindex);
			if (!Character.isAlphabetic(lchar)) {
				continue;
			}
			
			char rchar = 0;
			for (; rightindex > leftindex; rightindex--) {
				rchar = s.charAt(rightindex);
				if (!Character.isAlphabetic(rchar)) {
					continue;
				}
			}
			
			if (Character.toLowerCase(lchar) != Character.toLowerCase(rchar) ) {
				return false;
			}
		}
		
		return true;
	}
	*/
	
	public boolean isPalindrome(String s) {
		int leftindex = 0;
		int rightindex = s.length()-1;
		
		char lchar = 0;
		char rchar = 0;
		while (leftindex < rightindex) {
			while (condition) {
				
			}
		}
		for (; leftindex < rightindex; leftindex++) {
			char lchar = s.charAt(leftindex);
			if (!Character.isAlphabetic(lchar)) {
				continue;
			}
			
			char rchar = 0;
			for (; rightindex > leftindex; rightindex--) {
				rchar = s.charAt(rightindex);
				if (!Character.isAlphabetic(rchar)) {
					continue;
				}
			}
			
			if (Character.toLowerCase(lchar) != Character.toLowerCase(rchar) ) {
				return false;
			}
		}
		
		return true;
	}
}