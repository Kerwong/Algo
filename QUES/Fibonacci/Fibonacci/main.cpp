#include <iostream>

// recursion
int fibonacci_recur(int n){
	if(1 == n){
		return 1;
	}
	if(2 == n){
		return 1;
	}

	if(n >= 3){
		return fibonacci_recur(n-1) + fibonacci_recur(n-2);
	}
	return 0;
}

// loop

int Fib[255] = {0};

int fibonacci_loop(int n){
	Fib[0] = 1;
	Fib[1] = 1;

	for(int i = 2; i < n; i++){
		Fib[i] = Fib[i-1] + Fib[i-2];
		std::cout<<Fib[i]<<" ";
	}
	std::cout<<std::endl;
	return Fib[n-1];
}

int main(){


	std::cout<<fibonacci_recur(30);

	return 0;
}