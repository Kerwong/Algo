package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent. A mapping of digit to letters (just like on the telephone
 * buttons) is given below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * */

public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> strLists = new ArrayList<>();
		
		if (digits.length() == 0) {
			strLists.add("");
			return strLists;
		}
		
		
		List<String> tmpLists = new ArrayList<>();
		// "23"
		for (int i = 0; i < digits.length(); i++) {
			String str = digitMap(digits.charAt(i));
			
			tmpLists.clear();
			// "abc", "def"
			for (int j = 0; j < str.length(); j++) {
				if (i == 0) {
					tmpLists.add(String.valueOf(str.charAt(j)));
				} else {
					for (String string : strLists) {
						tmpLists.add(string + String.valueOf(str.charAt(j)));
					}
				}
			}
			strLists.clear();
			strLists.addAll(tmpLists);
		}
		
		return strLists;
	}

	private String digitMap(char digit) {
		if (digit < '2' || digit > '9') {
			return null;
		} else {
			switch (digit) {
			case '2':
				return "abc";
			case '3':
				return "def";
			case '4':
				return "ghi";
			case '5':
				return "jkl";
			case '6':
				return "mno";
			case '7':
				return "pqrs";
			case '8':
				return "tuv";
			case '9':
				return "wxyz";
			default:
				return "";
			}
		}
	}
}
