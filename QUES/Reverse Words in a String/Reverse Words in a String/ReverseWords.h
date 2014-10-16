#ifndef __REVERSE__
#define __REVERSE__

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    void reverseWords(string &s) {
		vector<string> strVec;
		
		int start, end;
		start = end = 0;
		int cur = 0;

		while(cur != string::npos){
			start = s.find_first_not_of(' ', cur);
			if(start == string::npos)
				break;
			end = s.find_first_of(' ', start) - 1;

			cur = end + 1;
			string str = s.substr(start, end - start + 1);
			strVec.push_back(str);
		}

		if(strVec.size() == 0) return;

		for(int i = strVec.size()-1; i > 0; i--){
			cout<<strVec[i]<<" ";
		}
		cout<<strVec[0];
    }
};

#endif
