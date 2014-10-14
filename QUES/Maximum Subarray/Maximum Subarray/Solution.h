#ifndef _SOLUTION_
#define _SOLUTION_

#include <iostream>
#include <Windows.h>

#define MINIMUM -65536

typedef struct {
	int left;
	int right;
	int max;
} sMax;

class Solution {
public:
    int maxProduct(int A[], int n) {
        
    }

	// Çî¾Ù£¬¸´ÔÓ¶È O(N^2)
	/*void maxSummary_1(int A[], int n, int& left, int& right, int& max) {

		left = 0;
		right = 0;
		max = MINIMUM;

		int sum = 0;
		for(int i=0; i < n; i++){
			for(int j = i; j < n; j++) {
				sum += A[j];
				if(sum > max){
					left = i;
					right = j;
					max = sum;
				}
			}
			sum = 0;
		}

		std::cout<<left<<" "<<right<<std::endl;
		return;
    }*/

	//
	int maxSummary_2(int A[], int n) {
		return maxSumSub(A, n);
	}

private:
	/*int maxSumSub(int A[], int n){
		if(n == 1) {
			return A[0];
		}
		else {
			if(A[n-1] >= 0)
				return max(A[n-1] + maxSumSub(A, n-1), A[n-1]);
			else {
				return max(maxSumSub(A, n-1), A[n-1]);
			}
		}
	}*/

	/*sMax maxSumSub(int A[], sMax info){
		if(info.left == info.right){
			info.max = A[info.left];
			return info;
		}

		maxinfo left;
		left.left = info.left;
		left.right = (info.left + info.right)/2;

		maxinfo right;
		right.left = (info.left + info.right )/2 + 1;
		right.right = info.right;

		if()
	}*/
};

#endif