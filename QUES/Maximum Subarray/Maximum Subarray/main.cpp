#include "Solution.h"
#include <iostream>

using namespace std;

int main() {
	
	int A[9] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	Solution* sol = new Solution();

	int left;
	int right;
	int max;
	sol->maxSummary_1(A, 9, left, right, max);
	return 0;
}