/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
#ifndef __Solution__
#define __Solution__

#include <iostream>
#include <string>

using namespace std;

#define NULL 0

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:

	// Merge sort
    ListNode *sortList(ListNode *head) {
		if( head == NULL )
			return NULL;

		if(head->next == NULL)
			return head;

		int len = 0;
		ListNode* curpos = head;
		while(curpos != NULL){
			len++;
			curpos = curpos->next;
		}

		ListNode* lList;
		ListNode* rList;
		curpos = head;
		for(int i=0; i < len/2; i++){
			curpos = curpos->next;
		}

		rList = curpos->next;
		curpos->next = NULL;
		lList = head;

		lList = sortList(lList);
		rList = sortList(rList);

		// merge
		ListNode* cur;
		
		head = lList->val > rList->val ? rList : lList;
		
		while(lList != NULL && rList != NULL){
			if(lList->val > rList->val){
				cur = rList->next;
				rList->next = lList;
				rList = cur;
				lList = lList->next;
			} else {
				cur = lList->next;
				lList->next = rList;
				lList = cur;
				rList = rList->next;
			}
		}

		return head;
    }
};

#endif