#include "Solution.h"
#include <vector>

using namespace std;

int main() {
	Solution* sol = new Solution();
	vector<int> numbers(3,0);
	numbers[0] = 3;
	numbers[1] = 2;
	numbers[2] = 4;
	vector<int> res;
	res = sol->twoSum2(numbers, 6);
	
	return 0;
}