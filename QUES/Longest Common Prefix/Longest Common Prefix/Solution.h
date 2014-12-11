#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        
		int len = strs.size();
		if(len == 0)
			return "";

		int ires = 0;
		
		while(true) {
			char c = strs[0][ires];
			if(c == '\0')
				return strs[0].substr(0, ires);
			for(int i=1; i<len; i++) {
				if(strs[i][ires] == '\0' || strs[i][ires] != c)
					return strs[0].substr(0, ires);
			}
			ires++;
		}
    }
};