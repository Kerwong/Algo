package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * */

public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		if (S==null || S.length()==0) {
			return null;
		}
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		for (String each : L) {
			Integer val;
			if((val = hMap.get(each)) != null) {
				hMap.put(each, val+1);
			} else {
				hMap.put(each, 1);
			}			
		}
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		int strCount = L.length;
		int perLen = L[0].length();
		int count = S.length() - strCount*perLen + 1;

		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
		String tmpStr;
		for (int i = 0; i < count; i++) {
			tmpMap.clear();
			
			int j = 0;
			for (; j < strCount; j++) {
				tmpStr = S.substring(i+j*perLen, i+(j+1)*perLen);
				
				if (!hMap.containsKey(tmpStr)) {
					break;
				}
				
				Integer val;
				if ((val = tmpMap.get(tmpStr)) != null) {
					if (val >= hMap.get(tmpStr)) {
						break;
					}
					tmpMap.put(tmpStr, val+1);
				} else {
					tmpMap.put(tmpStr, 1);
				}
			}
			
			if (j == strCount) {
				resultList.add(i);
			}
		}
		return resultList;
	}
}