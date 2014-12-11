#include "Solution.h"

ListNode* initalList(int A[], int n){
	ListNode* cur = new ListNode(A[0]);
	ListNode head = *cur;

	for(int i=1; i<n; i++){
		ListNode* ln = new ListNode(A[i]);
		cur->next = ln;
		cur = cur->next;
	}
	return &head;
}

int main(){
	Solution* sol = new Solution();

	int A[9] = {1,24,-5,7,0,33,9,-5,6};
	ListNode* ln = initalList(A, 9);

	ln = sol->sortList(ln);

	return 0;
}