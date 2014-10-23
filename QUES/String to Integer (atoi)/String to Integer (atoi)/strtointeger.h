#ifndef _STR2INTEGER_
#define _STR2INTEGER_

class Solution {
public:
    int atoi(const char *str) {
		
		int i = 0;
		int res = 0;
		bool posneg = true;
		bool spc = false;
		bool over = false;

		while(str[i] == ' ') {
			i++;
			spc = true;
		}

		if(str[i] == '-'){
			posneg = false;
			i++;
		}
		else if(str[i] == '+'){
			i++;
		}

		while(str[i] != '\0') {
			if(str[i] == ' ') {
				if(spc)
					break;
				i++;
				continue;
			}

			if(str[i] > '9' || str[i] < '0')
				break;
			else {
				int tmp;
				tmp = str[i] - '0';
				if(res > 214748364)
					over = true;
				res = 10*res + tmp;

				if(res < 0)
					over = true;
				i++;
				spc = true;
				
			}
		}

		if(posneg) {
			if(over)
				return 2147483647;
			return res;
		} else {
			if(over)
				return -2147483648;
			return 0 - res;
		}
    }
};

#endif