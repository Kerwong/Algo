#include "ReverseWords.h"
#include <iostream>

using namespace std;

int main(){
	//string str = "      1         ";
	string str;
	//string str = "         ";
	//string str = "the sky is blue";
	//string str = "the sky is blue        ";
	//string str = "    the sky is blue";
	//string str = "the       sky is blue";
	//string str = "t";
	//string str = "t    ";
	//string str = "       t";
	//string str = "        t       sky is blue";
	
	Solution* sol = new Solution();
	sol->reverseWords(str);

	return 0;
}