package com;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all 
 * valid but "(]" and "([)]" are not.
 * */

public class Solution {
	
	public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<Character>();
        
        int len = s.length();
        for (int i=0; i<len; i++) {
        	char tmp = s.charAt(i);
        	if(tmp == '(' || tmp == '{' || tmp == '[')
        		bracketStack.push(Character.valueOf(s.charAt(i)));
        	else {
        		if (bracketStack.empty()) {
					return false;
				}
        		char tmp1 = bracketStack.pop();
        		
        		
        		if (tmp == ')') {
        			if (tmp1 == '(') {
						continue;
					} else {
						return false;
					}
				}
        		
        		if (tmp == ']') {
        			if (tmp1 == '[') {
						continue;
					} else {
						return false;
					}
				}
        		
        		if (tmp == '}') {
        			if (tmp1 == '{') {
						continue;
					} else {
						return false;
					}
				}
        	}
        }
        
        if (bracketStack.empty()) {
			return true;
		} else {
			return false;
		}
    }
}
