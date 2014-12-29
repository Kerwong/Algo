package com;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Given a string, find the length of the longest substring without repeating 
 * characters. For example, the longest substring without repeating letters for 
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest 
 * substring is "b", with the length of 1.
 * */

public class Solution {
	//wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco
	public int lengthOfLongestSubstring(String s) {
		
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		
		int prevIndex = -1;
		int maxLen = 0;
		int curLen = 0;
		
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (!hMap.containsKey(ch)) {
				hMap.put(ch, i);
				curLen++;
			} else {
				int tmpIndex = hMap.get(ch);				
				if (tmpIndex > prevIndex) {
					prevIndex = tmpIndex;					
				}				
				hMap.put(ch, i);
			}			
			maxLen = Math.max(maxLen, i - prevIndex);
		}
        return maxLen;
    }
}
