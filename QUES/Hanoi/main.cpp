#include <iostream>

// recursion
int hanoi(int n, char a, char b, char c){
	int step = 0;
	if(0 >= n){
		return 0;
	}

	if(1 == n){
		std::cout<<"Move "<<a<<" to "<<c<<std::endl;
		return 1;
	}

 	if(n >= 2){
		step += hanoi(n-1, a, c, b);
		std::cout<<"Move "<<a<<" to "<<c<<std::endl;
		step++;
		step += hanoi(n-1, b, a, c);
	}
	return step;
}

int main(){
	int n = 0;
	std::cout<<"Please input an integer:";
	std::cin>>n;
	std::cout<<"Total steps: "<<hanoi(n, 'A', 'B', 'C')<<std::endl;
	return 0;
}