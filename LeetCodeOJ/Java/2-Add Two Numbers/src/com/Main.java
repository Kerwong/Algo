package com;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
		
		ListNode l2 = new ListNode(0);
		
		/*l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);*/
		
		Solution sol = new Solution();
		ListNode ret = sol.addTwoNumbers(l1, l2);
		
		
	}

}
