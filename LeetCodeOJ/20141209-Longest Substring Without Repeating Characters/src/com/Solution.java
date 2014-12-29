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
	public int lengthOfLongestSubstring(String s) {
		
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		
		int index = -1;
		int maxLen = 0;
		
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (!hMap.containsKey(ch)) {
				hMap.put(ch, i);
				maxLen++;
			} else {
				int tmp = hMap.get(ch);
				if(i - tmp > maxLen) {
					if (tmp > index) {
						index = tmp;
						maxLen = i - tmp;
					}
				}
				
				if (tmp > index) {
					index = tmp;
				}
				hMap.put(ch, i);
			}
		}
        return 0;
    }
}
