package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * */

public class Solution {
	public List<String> generateParenthesis(int n) {
		
		List<String> list = new ArrayList<>();
		
		String par = "(";
		appendParentheses(par, n-1, n, list);
		
		return list;
    }
	
	private void appendParentheses(String par, int left, int right, List<String> ret) {
		if (left == 0 && right == 0) {
			ret.add(par);
		} else if (left == 0 && right != 0) {
			for (int i = 0; i < right; i++) {
				par += ")";
			}
			ret.add(par);
		} else if (left > right) {
			return;
		} else {
			if (left == right) {
				appendParentheses(par+"(", left-1, right, ret);
			} else {
				appendParentheses(par+"(", left-1, right, ret);
				appendParentheses(par+")", left, right-1, ret);
			}
			
		}
	}
}