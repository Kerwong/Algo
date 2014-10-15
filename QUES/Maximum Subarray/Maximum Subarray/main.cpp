#include "Solution.h"
#include <iostream>

using namespace std;

int main() {
	
	int A[9] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	//int A[9] = {-2,-1,-3,-5,-4,-8,-10,-3,-2};
	Solution* sol = new Solution();

	int sum = sol->maxSummary_3(A, 9);
	return 0;
}