#ifndef __SOLUTION__
#define __SOLUTION__

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    /*vector<int> getRow(int rowIndex) {        
        vector<int> iVec(rowIndex+1, 0);
        for(int i=0; i<rowIndex/2+1;i++){
            long long a = 1.0;
            long long b = 1.0;
            for(int j=0; j<i;j++){
                a *= (rowIndex-j);
                b *= (1+j);
            }
			cout<<a<<"\t"<<b<<"\t"<<a/b<<endl;
            iVec[i] = a/b;
            iVec[rowIndex-i] = a/b;
        }
        
        return iVec;
    }*/

	vector<int> getRow(int rowIndex) {
		vector<int> iVec(rowIndex+1, 1);
		
		for(int i=2; i <= rowIndex; ++i){
			for(int j=i-1; j > 0; --j) {
				iVec[j] = iVec[j-1] + iVec[j];
			}
		}

		return iVec;
	}

	vector<vector<int> > generate(int numRows) {
		vector<vector<int>> resVec;

		if(0 == numRows){
			return resVec;
		}
		
		vector<int> iVec(1, 1);
		resVec.push_back(iVec);

		if(1 == numRows) {
			return resVec;
		}

		vector<int> preVec(2, 1);
		resVec.push_back(preVec);

		if(2 == numRows) {
			return resVec;
		}

		for(int i=3; i <= numRows; i++) {
			vector<int> curVec(i, 1);
			for(int j=1; j<i-1; j++){
				curVec[j] = preVec[j] + preVec[j-1];
			}
			resVec.push_back(curVec);
			preVec = curVec;
		}

		return resVec;
    }
};

#endif

