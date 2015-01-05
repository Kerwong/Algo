package com;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating 
 * characters. For example, the longest substring without repeating letters 
 * for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest 
 * substring is "b", with the length of 1.
 */

public class Solution {
	
	/**
	 * SOLUTION 1:
	 * FAILED, 思路存在严重问题*/
	/*public int lengthOfLongestSubstring(String s) {
		
        int prevIndex = 0;
        int nextIndex = 0;
        
        int retLen = 0;
		HashSet<Character> charSet = new HashSet<Character>();
        
        while (nextIndex != s.length()) {
			if (charSet.contains(s.charAt(nextIndex))) {
				if (nextIndex - prevIndex > retLen) {
					retLen = nextIndex - prevIndex;
				}
				charSet.clear();
				charSet.add(s.charAt(nextIndex));
				prevIndex = nextIndex++;
			} else {
				charSet.add(s.charAt(nextIndex));
				nextIndex++;
			}
		}
        
        if (nextIndex - prevIndex > retLen) {
        	retLen = nextIndex - prevIndex;;
		}
        return retLen;
    }*/
	
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		
		int fromIndex = -1;
		int curIndex = 0;
		while (curIndex != s.length()) {
			if (hMap.containsKey(s.charAt(curIndex))) {
				
				
			} else {

			}
		}
		
		return 0;
	}
}