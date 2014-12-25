package com;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		
		String[] xx = {"0","3","/"};
		String[] yy = {"2", "1", "+", "3", "*"};
		String[] zz = {"4", "13", "5", "/", "+"};
		int x = sol.evalRPN(zz);
	}

}
