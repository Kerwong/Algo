package com;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, retStrurn 321
 * Example2: x = -123, retStrurn -321
 * */

/**
 * WARNING:注意逆序后范围越界的问题
 * */
public class Solution {
	
	public int reverse(int x) {
		String retStr = "";
		
		if (x < 0) {
			retStr = "-";
			x = 0 - x;
		}
		
		int remainder = 0;
		int quotient = x;
		
		while (quotient != 0) {
			remainder = quotient % 10;
			quotient = quotient / 10;
			retStr = retStr + remainder;
		}
		
		int ret = 0;
		
		try {
			ret = Integer.valueOf(retStr);
		} catch (Exception e) {
			return 0;
		}		
		
		return ret;
    }
	
}
