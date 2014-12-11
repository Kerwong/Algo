#ifndef __SOLUTION__
#define __SOLUTION__

#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
		int len = s.length();

		if(len <= 0)
			return 0;

		vector<int> iVec(len, 1);

		for(int i = 0; i < len; i++) {
			if(s[i] == 'M')
				iVec[i] = 1000;
			else if(s[i] == 'D')
				iVec[i] = 500;
			else if(s[i] == 'C')
				iVec[i] = 100;
			else if(s[i] == 'L')
				iVec[i] = 50;
			else if(s[i] == 'X')
				iVec[i] = 10;
			else if(s[i] == 'V')
				iVec[i] = 5;
			else if(s[i] == 'I')
				iVec[i] = 1;
			else
				return 0;
		}

		int res = iVec[len-1];
		for(int i = len-2; i >= 0; i--) {
			if(iVec[i] >= iVec[i+1])
				res += iVec[i];
			else
				res -= iVec[i];
		}

		return res;
    }
};

#endif