#include <stdlib.h>
#include <iostream>
#include <time.h>
#include <fstream>

using namespace std;

int main() {
	ofstream fout;
	fout.open("1.txt");
	srand(1);
	for(int i=0; i<10000; i++)
		fout<<rand()<<"  ";

	return 0;
}