#ifndef _PALINDROME_
#define _PALINDROME_

#include <string>

using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
		
		if(x < 0)
			return false;

		string res = numToString(x);

		int len = res.length();
		for(int i = 0; i < len/2; i++) {
			
			if(res[i] != res[len-i-1]) {
				return false;
			}
		}

		return true;

    }

	string numToString(int x) {
		string res = "";

		int remainder;
		int quotient = 1;

		while(0 != x) {
			remainder = x % 10;
			char c = '0' + remainder;
			res = res + c;
			x = x / 10;
		}

		return res;
	}	
};

#endif