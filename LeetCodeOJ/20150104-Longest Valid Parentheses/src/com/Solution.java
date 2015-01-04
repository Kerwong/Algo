package com;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * */

public class Solution {
	/** SOLUTION 1: WRONG ANSWER
	 * Input:	"()(()"
	 * Output:	4
	 * Expected:	2*/
	/*
	public int longestValidParentheses(String s) {
		if (s == null || s.length()==0) {
			return 0;
		}
		
		Stack<Character> parentheseStack = new Stack<Character>();
		int index = 0;
		while (index < s.length() && s.charAt(index)==')') {	
			// 注意 index < s.length() && s.charAt(index)==')' 与 s.charAt(index)==')' && index < s.length() 的区别，后者会报越界错误
			index++;
		}
		
		int count = 0;
		for (; index < s.length(); index++) {
			if (s.charAt(index)=='(') {
				parentheseStack.push('(');
			} else {
				if (!parentheseStack.empty()) {
					parentheseStack.pop();
					count += 2;
				}
			}
		}
		
		return count;
	}
	*/
	
	/** SOLUTION 2: 标记每一个合理的位置为 TRUE，复杂度为 O(N^2)
	 * ACCEPTED*/
	public int longestValidParentheses(String s) {
		if (s == null || s.length()==0) {
			return 0;
		}

		boolean[] bArray = new boolean[s.length()];
		
		int index = 0;
		while (index < s.length()) {
			if (s.charAt(index)==')') {
				for (int i = index-1; i >= 0; i--) {
					if (!bArray[i] && s.charAt(i)=='(') {
						bArray[i] = true;
						bArray[index] = true;
						break;
					}
				}
			} else {
				bArray[index] = false;
			}
			index++;
		}

		int count = 0;
		int max = 0;
		for (int i = 0; i < bArray.length; i++) {
			if (bArray[i]) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 0;
			}
		}
		return Math.max(max, count);
	}
	
	/** SOLUTION 3: dp
	 * 待定*/
}