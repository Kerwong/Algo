package com;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * */

public class Solution {
	/** SOLUTION 1: FAILED
	 * 题目理解错误，理解成了 包含，实际应该是 完全匹配*/
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return true;
		}
		
        String[] strs = p.split("\\*");
        String newP = "";
        
        for (int i = 0; i < strs.length; i++) {
        	if (strs[i].charAt(strs[i].length()-1) == '*') {
        		newP += strs[i].substring(0, strs[i].length()-2);
			}
        	newP += strs[i];
		}
        
        for (int i = 0; i < s.length(); i++) {
        	int j = 0;
			for (; j < newP.length(); j++) {
				if (newP.charAt(j) != '.') {
					if (i+j >= s.length()) {
						break;
					}
					if (newP.charAt(j) == s.charAt(i+j)) {
						continue;
					} else {
						break;
					}
				}
			}
			if (j == newP.length()) {
				return true;
			}			
		}
        return false;
    }
}
