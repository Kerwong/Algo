package com;

/**
 * Given a linked list, remove the nth node from the end of list and return its 
 * head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, 
 * the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
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
	
	/**
	 * SOLUTION 1:
	 * */
	/*public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = getListLength(head);
		
		ListNode pNode = head;
		
		if (n == len)
			return head.next;
		
		int i = 1;
		while (i < len-n) {
			pNode = pNode.next;
			i++;
		}
		
		pNode.next = pNode.next.next;
		
		return head;
    }
	
	private int getListLength(ListNode head) {
		if (head == null)
			return 0;
		
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}*/
	
	/**
	 * SOLUTION 2:
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preNode = head;
		ListNode nextNode = head;
		
		for (int i=0; i<n; i++) {
			nextNode = nextNode.next;
		}
		
		if(nextNode == null) {
			head = head.next;
			return head;
		}
		
		while (nextNode.next != null) {
			preNode = preNode.next;
			nextNode = nextNode.next;
		}
		
		preNode.next = preNode.next.next;
		
		return head; 
    }
}
