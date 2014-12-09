#ifndef __SOLUTION__
#define __SOLUTION__

#include <string>
#include <iostream>
#include <stdio.h>

using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if(n <= 0)
			return "";
		if(n == 1)
			return "1";
		if(n == 2)
			return "11";
		
		string res = "";
		string cur = "11";

		char c;
		int pre;
		char t[256];
		string s;
		int num;
		for(int i = 3; i <= n; i++) {
			pre = 0;
			c = cur[pre];
			res = "";
			for(int j=0; j<cur.length();){
				if(cur[j] == c){
					j++;
				} else {
					num = j - pre;
					//itoa(num, t, 10);
					sprintf(t, "%d", num);
					s = t;
					res = res + s + c;
					c = cur[j];
					pre = j;
					j++;
				}

				if(j == cur.length()) {
					num = j - pre;
					//itoa(num, t, 10);
					sprintf(t, "%d", num);
					s = t;
					res = res + s + c;
				}
			}
			cur = res;
		}

		return res;
    }
};

#endif