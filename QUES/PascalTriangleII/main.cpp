#include "Solution.h"
#include <iostream>

using namespace std;

int main(){
	Solution* sol = new Solution();
	
	//vector<int> resVec = sol->getRow(31);
	int n = 4;
	vector<vector<int>> resVec = sol->generate(n);
	for(int i=0; i<resVec[n-1].size(); i++){
		cout<<resVec[n-1][i]<<endl;
	}
	return 0;
}