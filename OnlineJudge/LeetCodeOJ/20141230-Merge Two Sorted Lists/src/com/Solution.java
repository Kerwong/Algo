package com;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the 
 * first two lists.
 * */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) {
			return  null;
		} else if (l1 == null && l2 != null) {
			return l2;
		} else if (l1 != null && l2 == null) {
			return l1;
		}
    	
        ListNode head = new ListNode(0);
        ListNode pNode1 = l1;
        ListNode pNode2 = l2;
        ListNode curNode;
        if (l1.val < l2.val) {
			head.next = l1;
			curNode = pNode1;
			pNode1 = l1.next;			
		} else {
			head.next = l2;
			curNode = pNode2;
			pNode2 = l2.next;
		}
        
        while (pNode1 != null && pNode2 != null) {
        	if (pNode1.val < pNode2.val) {
				curNode.next = pNode1;
				curNode = pNode1;
				pNode1 = pNode1.next;
			} else {
				curNode.next = pNode2;
				curNode = pNode2;
				pNode2 = pNode2.next;
			}
		}
        
        if (pNode1 == null) {
        	curNode.next = pNode2;
		}
        if (pNode2 == null) {
        	curNode.next = pNode1;
		}
        
        return head.next;
    }
}