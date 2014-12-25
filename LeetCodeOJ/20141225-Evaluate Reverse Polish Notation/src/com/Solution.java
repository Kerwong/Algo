package com;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Known as postfix notation. Valid operators are +, -, *, /. Each operand may
 * be an integer or another expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 */

public class Solution {
	/** SOLUTION 1 */
	/*
	public int evalRPN(String[] tokens) {
		Stack<Integer> rpnStack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-")
					|| tokens[i].equals("*") || tokens[i].equals("/")) {
				calcRPN(rpnStack, tokens[i]);
			} else {
				rpnStack.push(Integer.valueOf(tokens[i]));
			}
		}
		return rpnStack.pop();
	}
	*/
	private void calcRPN(Stack<Integer> rpnStack, String operator) {
		int param2 = rpnStack.pop();
		int param1 = rpnStack.pop();

		if (operator == "+") {
			rpnStack.push(param1 + param2);
		} else if (operator == "-") {
			rpnStack.push(param1 - param2);
		} else if (operator == "*") {
			rpnStack.push(param1 * param2);
		} else if (operator == "/") {
			rpnStack.push(param1 / param2);
		}
	}

	public int evalRPN(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
	}
}