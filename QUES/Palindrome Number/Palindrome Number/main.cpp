#include "Palindrome Number.h"
#include <iostream>

using namespace std;

int main() {
	Solution* sol = new Solution();

	if( sol->isPalindrome(101) ){
		cout<<"TRUE";
	} else {
		cout<<"FALSE";
	}

	return 0;
}

