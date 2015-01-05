package com;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinStack minStack = new MinStack();
		
		//minStack.push(-3);
		
		//push(-2),push(0),push(-1),getMin,top,pop,getMin
		/*minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		minStack.getMin();
		minStack.top();
		minStack.pop();*/		
		
		// solution 4: Wrong Answer
		// push(0),push(1),push(0),getMin,pop,getMin
		minStack.push(0);
		minStack.push(0);
		minStack.push(0);
		minStack.getMin();
		minStack.pop();
		int x = minStack.getMin();
	}

}
