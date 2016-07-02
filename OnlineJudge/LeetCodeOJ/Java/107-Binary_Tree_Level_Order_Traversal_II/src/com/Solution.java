package com;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists: 
 * 		A: a1 ¡ú a2 
 * 				¨K
 * 			 	c1 ¡ú c2 ¡ú c3 
 * 				¨J
 * B:b1¡ú b2 ¡ú b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes: If the two linked lists have no intersection at all, return null. The
 * linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
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

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		int lenA = 1;
		int lenB = 1;
		ListNode a = headA;
		ListNode b = headB;
		
		while (a.next != null) {
			lenA++;
			a = a.next;
		}
		
		while (b.next != null) {
			lenB++;
			b = b.next;
		}
		
		if (a.val != b.val) {
			return null;
		}
		
		if (lenA > lenB) {
			a = moveSteps(headA, lenA - lenB);
		} else {
			b = moveSteps(headB, lenB - lenA);
		}
		
		while (a.val != b.val) {
			a = a.next;
			b = b.next;
		}
		
		return a;
	}
		
	private ListNode moveSteps(ListNode list, int step) {
		ListNode l = list;
		
		for (int i = 0; i < step; i++) {
			l = l.next;
		}
		
		return l;
	}
}
