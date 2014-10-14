#include "Solution.h"
#include <iostream>

using namespace std;

int main() {
	
	int A[9] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	Solution* sol = new Solution();

	sol->maxSummary_2(A, 9);
	return 0;
}