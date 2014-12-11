#ifndef __SOLUTION__
#define __SOLUTION__

class Solution {
public:
    int lengthOfLastWord(const char *s) {
		int len = 0;
        int wlen = 0;

		while(s[len] != '\0')
			len++;

		int i = len - 1;
		while(i >= 0 && s[i] == ' ')
			i--;

		if(i < 0)
			return 0;
		else {
			while(i >=0 && s[i--] != ' ')
				wlen++;
		}

		return wlen;
    }
};

#endif