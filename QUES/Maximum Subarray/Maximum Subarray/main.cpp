#include "Solution.h"
#include <iostream>

using namespace std;

int main() {
	
	int A[13] = {-4,1,4,6,3,-10,0,3,-2,4,11,-20,40};
	Solution* sol = new Solution();
	int res = sol->maxSummary_2(A, 8);
	return 0;
}