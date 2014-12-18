package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 *Design a stack that supports push, pop, top, 
 *and retrieving the minimum element in constant time.
 *
 *push(x) -- Push element x onto stack.
 *pop() -- Removes the element on top of the stack.
 *top() -- Get the top element.
 *getMin() -- Retrieve the minimum element in the stack.
 * */

/* SOLUTION 1: 
 * Time Limit Exceeded*/
/*class MinStack {
	private Stack<Integer> content = new Stack<>();
	private int minElement = Integer.MAX_VALUE;
	
    public void push(int x) {
    	content.add(x);
    }

    public void pop() {
        if (!content.empty()) {
        	content.pop();			
		}
    }

    public int top() {
        if (!content.empty()) {
			return content.peek();
		}
        return -1;
    }

    public int getMin() {    	
    	for (Iterator<Integer> iter = content.iterator(); iter.hasNext();) {
			Integer tmp = (Integer) iter.next();
			if (tmp < minElement) {
				minElement = tmp;
			}
		}
    	return minElement;
    }
}*/

/* SOLUTION 2:
 * Memory Limit Exceeded
 */
/*
class MinStack {
	private ArrayList<Integer> sortedList = new ArrayList<>();
	private Stack<Integer> content = new Stack<>();
	
    public void push(int x) {
    	content.add(x);
    	
    	// insert index into arraylist
    	insertSorted(x, 0, content.size()-1);
    }
    
    private void insertSorted(int value, int left, int right) {
    	if (left == right) {
			sortedList.add(left, value);
			return;
		}
    	int mid = (left + right)/2;
		if (sortedList.get(mid) > value) {
			insertSorted(value, left, mid);
		} else if (sortedList.get(mid) < value) {
			insertSorted(value, mid+1, right);	// 注意，一开始写错为 mid, right，这会造成无限循环，因此需要mid+1
		} else {
			sortedList.add(mid, value);
		}
	}

    public void pop() {
        int value = content.pop();
        deleteSorted(value, 0, sortedList.size()-1);	// 注意右边界限为 sortedlist 与 content 的较大值
    }
    
    private void deleteSorted(int value, int left, int right) {
    	if (left == right) {
			sortedList.remove(left);
			return;
		}
    	int mid = (left + right)/2;
		if (sortedList.get(mid) > value) {
			deleteSorted(value, left, mid);
		} else if (sortedList.get(mid) < value) {
			deleteSorted(value, mid+1, right);
		} else {
			sortedList.remove(mid);
		}
	}
    
    public int top() {
    	int value = content.peek();
        return value;
    }

    public int getMin() {
        return sortedList.get(0);
    }
}*/

/* SOLUTION 3:
 *  Memory Limit Exceeded*/
/*
class MinStack {
	private Stack<Integer> content = new Stack<>();
	private Integer minEle = Integer.MAX_VALUE;
	
    public void push(int x) {
    	if (x < minEle) {
    		minEle = x;
		}

		content.add(minEle);
		content.add(x);
    }

    public void pop() {
        content.pop();	
        content.pop();	// pop minEle
    }

    public int top() {
        return content.peek();
    }

    public int getMin() {
        return content.get(content.size()-2);
    }
}
*/

/* SOLUTION 4:
 *  Wrong Answer*/
/*
class MinStack {
	private Stack<Integer> minStack = new Stack<>();
	private Stack<Integer> minElements = new Stack<>();
	
	public MinStack() {
		// TODO Auto-generated constructor stub
		minElements.add(Integer.MAX_VALUE);
	}
	
    public void push(int x) {
    	minStack.add(x);
    	if (minElements.peek() > x) {
			minElements.add(x);
		}
    }

    public void pop() {
        int value = minStack.pop();
        if (value == minElements.peek()) {
			minElements.pop();
		}
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minElements.peek();
    }
}
*/


class MinStack {
	class Pair {
		int val;
		int count;
		Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			val = x;
			count = y;
		}
	}
	
	private Stack<Integer> minStack = new Stack<>();
	private Stack<Pair> minElements = new Stack<>();
	
	public MinStack() {
		// TODO Auto-generated constructor stub
		minElements.add(new Pair(Integer.MAX_VALUE, 0));
	}
	
    public void push(int x) {
    	minStack.add(x);
    	Pair pair = minElements.peek();
    	if (pair.val > x) {
			minElements.add(new Pair(x, 1));
		} else if (pair.val == x) {
			pair.count++;
		}
    }

    public void pop() {
        int value = minStack.pop();
        Pair pair = minElements.peek();
        if (value == pair.val) {
			if (pair.count == 1) {
				minElements.pop();
			} else {
				pair.count--;
			}
		}
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minElements.peek().val;
    }
}
