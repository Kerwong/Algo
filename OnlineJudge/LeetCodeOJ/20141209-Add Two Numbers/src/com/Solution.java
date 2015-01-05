package com;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a 
 * single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int tmp;
		
		ListNode pNode = new ListNode(-1);
		
		ListNode headNode = pNode;
		while (l1 != null || l2 != null) {
			if(l1 == null) {
				tmp = l2.val + carry;
				l2 = l2.next;
			} else if (l2 == null) {
				tmp = l1.val + carry;
				l1 = l1.next;
			} else {
				tmp = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			
			carry = tmp / 10;
			tmp = tmp % 10;
			
			pNode.next = new ListNode(tmp);
			pNode = pNode.next;
		}
		
		if (carry != 0)
			pNode.next = new ListNode(carry);
		
        return headNode.next;
    }
}
