#ifndef _SOLUTION_
#define _SOLUTION_

#include <iostream>
#include <algorithm>

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

	// 穷举，复杂度 O(N^2)
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

	// 分治法 Divide and Conquer
	int maxSummary_2(int A[], int n) {
		int low, high, max;
		findMaxSub(A, 0, n-1, low, high, max);
		std::cout<<low<<" "<<high<<" "<<max<<std::endl;
		return 0;
	}

	// Kadane Algo
	int maxSummary_3(int A[], int n){
		int mmax = A[0];
		int cursum = 0;

		for(int i = 0; i < n; ++i){
			cursum = cursum < 0 ? A[i] : cursum + A[i];
			mmax = std::max(cursum, mmax);
		}

		return mmax;
	}

	int maxSummary_3(int A[], int n){
		int mmax = A[0];
		int sum = A[0];

		for(int i=1; i < n; i++){
			if(sum <= 0){
				sum = A[i];
				mmax = std::max(sum, mmax);
			} else {
				if(A[i] <= 0){
					mmax = std::max(mmax, sum);
					sum += A[i];
				} else {
					sum += A[i];
					mmax = std::max(mmax, sum);
				}				
			}
		}
		return mmax;
	}

private:

	void findMaxSub(int A[], int left, int right, int& low, int& high, int& max){
		if(left == right) {
			low = left;
			high = right;
			max = A[left];
		}
		else {
			int mid = (left+right)/2;
			int llow, lhigh, lmax;
			findMaxSub(A, left, mid, llow, lhigh, lmax);

			int rlow, rhigh, rmax;
			findMaxSub(A, mid+1, right, rlow, rhigh, rmax);

			int clow, chigh, cmax;
			findMaxCrossSub(A, left, mid, right, clow, chigh, cmax);

			if(lmax >= rmax && lmax >= cmax){
				low = llow;
				high = lhigh;
				max = lmax;
			} else if(rmax >= lmax && rmax >= cmax){
				low = rlow;
				high = rhigh;
				max = rmax;
			} else {
				low = clow;
				high = chigh;
				max = cmax;
			}
		}
	}

	// Find the Max cross left subarray and right subarray
	void findMaxCrossSub(int A[], int left, int mid, int right, int& low, int& high, int& max){
		if(left == right){
			low = left;
			high = right;
			max = A[left];
		} else {
			int lmax = MINIMUM;
			int sum = 0;
			for(int i = mid; i >=left; i--){
				sum += A[i];
				if(sum > lmax){
					lmax = sum;
					low = i;
				}
			}
			sum = 0;
			int rmax = MINIMUM;
			for(int i = mid+1; i <= right; i++){
				sum += A[i];
				if(sum > rmax){
					rmax = sum;
					high = i;
				}
			}
			max = lmax + rmax;
		}
	}

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