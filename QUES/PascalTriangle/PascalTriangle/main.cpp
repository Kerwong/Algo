#include <iostream>
#include <vector>

using namespace std;

int combi(int n, int t){
	int res = 1;

	if(t > n){
		return -1;
	} else {
		 for(int i=0; i < t; i++){
			res = res * (n-i) / (i+1);
		 }
		 return res;
	}

}

int main(){
	int n;
	cin>>n;

	for(int i = 0; i <= n; i++){
		cout<<combi(n,i)<<" ";
	}
	

	return 0;
}