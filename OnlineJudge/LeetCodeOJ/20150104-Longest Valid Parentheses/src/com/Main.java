package com;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		//int ret = solution.longestValidParentheses(")");
		int ret = solution.longestValidParentheses(")()())");
		System.out.println(ret);
	}
}
