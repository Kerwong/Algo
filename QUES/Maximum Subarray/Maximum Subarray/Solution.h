#ifndef _SOLUTION_
#define _SOLUTION_

#include <iostream>
#include <Windows.h>

class Solution {
public:
    int maxProduct(int A[], int n) {
        
    }

	// Çî¾Ù£¬¸´ÔÓ¶È O(N^2)
	int maxSummary_1(int A[], int n) {
		
		int** res;
		res = new int*[n];
		for(int i=0; i<n; i++){
			res[i] = new int[n];
		}

		int a = 0;
		int b = 0;
		int max = 0;

		for(int i=0; i < n; i++){
			res[i][i] = A[i];
			for(int j = i+1; j < n; j++) {
				res[i][j] = res[i][j-1] + A[j];
				if(res[i][j] > max){
					max = res[i][j];
					a = i;
					b = j;
				}
			}
		}

		std::cout<<a<<" "<<b<<std::endl;
		return max;
    }

	//
	int maxSummary_2(int A[], int n) {
		return maxSumSub(A, n);
	}

private:
	int maxSumSub(int A[], int n){
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
	}
};

#endif