package com;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * */

public class Solution {
	
	/**
	 * SOLUTION 1: FAILED
	 * Time Limit Exceeded
	 * */
	/*public String longestPalindrome(String s) {
		if (s == null)
			return null;
		
		if (s.length() == 1)
			return s;
		
		for(int i=0, j=s.length()-1; i <= j-1; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				String leftStr = longestPalindrome(s.substring(0, j));
				String rightStr = longestPalindrome(s.substring(1, j+1));
				
				if (leftStr.length() > rightStr.length())
					return leftStr;
				else 
					return rightStr;
			}
		}
        return s;
    }*/
	
	/**
	 * SOLUTION 2
	 * */
	public String longestPalindrome(String s) {
		
		String longestStr = getOddLongestPalindrome(s, 0);
		String oddStr, evenStr;
		for (int i=1; i < s.length(); i++) {
			oddStr = getOddLongestPalindrome(s, i);
			
			if (s.charAt(i) == s.charAt(i-1))
				evenStr = getEvenLongestPalindrome(s, i-1);
			else
				evenStr = "";
			
			if(oddStr.length() > longestStr.length())
				longestStr = oddStr;
			if(evenStr.length() > longestStr.length())
				longestStr = evenStr;
		}
		
		return longestStr;
	}
	
	private String getOddLongestPalindrome(String s, int index) {
		int len = s.length();
		
		int i=0;
		for (; index-i>=0 && index+i<len; i++) {
			if (s.charAt(index-i) != s.charAt(index+i))
				return s.substring(index-i+1, index+i);
		}
		
		if(index-i<0 || index+i>=len)
			return s.substring(index-i+1, index+i);
		
		return s.substring(index, index+1);
	}
	
	private String getEvenLongestPalindrome(String s, int index) {
		int len = s.length();
		
		int i=1;
		for (; index-i>=0 && index+1+i<len; i++) {
			if (s.charAt(index-i) != s.charAt(index+1+i))
				return s.substring(index-i+1, index+1+i);
		}
		
		if(index-i<0 || index+1+i>=len)
			return s.substring(index-i+1, index+i+1);
		
		return s.substring(index, index+2);
	}
	
	
	
}
