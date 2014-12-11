#ifndef __SOLUTION__
#define __SOLUTION__

#include <vector>
#include <map>

using namespace std;

class Solution {
public:

	// O(n^2)
    vector<int> twoSum1(vector<int> &numbers, int target) {
		vector<int> res(2, 0);

		int len = numbers.size();
		
		for(int i=0; i<len; i++) {
			res[0] = i+1;
			
			for(int j=i+1; j<len; j++) {
				if(numbers[j] == target - numbers[i]) {
					res[1] = j+1;
					return res;			
				}
			}
		}

		return res;
    }

	vector<int> twoSum2(vector<int> &numbers, int target) {
		map<int, int> hm;
		vector<int> res(2,0);

		for(int i=0; i<numbers.size(); i++) {
			if(!hm.count(numbers[i]))
				hm[numbers[i]] = i+1;
		}

		for(int i=0; i<numbers.size(); i++) {
			if(hm.find(target - numbers[i]) != hm.end()) {
				if(hm[target - numbers[i]] == i+1)
					continue;
				if(i+1 > hm[target - numbers[i]]) {
					res[0] = hm[target - numbers[i]];
					res[1] = i+1;
				} else {
					res[0] = i + 1;
					res[1] = hm[target - numbers[i]];
				}
				return res;
			}
		}
		return res;
	}
};

#endif