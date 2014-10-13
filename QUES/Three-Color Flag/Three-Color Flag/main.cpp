#include <iostream>

using namespace std;

int iFlags[] = {1,2,3,2,1,2,3,1,2,3,1,2,3,1,2,3};

void swap(int a, int b){
	int temp;

	temp = iFlags[b];
	iFlags[b] = iFlags[a];
	iFlags[a] = temp;
}

void threeFlag(int len){	
	
	int flg1 = 0;
	int flg2 = 0;
	int flg3 = len-1;

	while(flg2 <= flg3){
		if(2 == iFlags[flg2]){
			++flg2;
		} else if(1 == iFlags[flg2]){
			swap(flg1, flg2);
			++flg1;
			++flg2;
		} else {
			while(flg2 < flg3 && iFlags[flg3] == 3)
				flg3--;
			swap(flg2, flg3);
			flg3--;
		}
	}
}


int main(){
	
	// cal length
	int len = sizeof(iFlags)/sizeof(iFlags[0]);

	threeFlag(len);
	return 0;
}


//#define BLUE 'b'
//#define WHITE 'w'
//#define RED 'r'
//#define SWAP(x, y) { char temp; \
//	temp = color[x]; \
//	color[x] = color[y]; \
//	color[y] = temp; }
//
//int main() {
//	char color[] = {'r', 'w', 'b', 'w', 'w','b', 'r', 'b', 'w', 'r', '\0'};
//	int wFlag = 0;
//	int bFlag = 0;
//	int rFlag = strlen(color) - 1;
//	int i;
//	for(i = 0; i < strlen(color); i++)
//		printf("%c ", color[i]);
//	printf("\n");
//	while(wFlag <= rFlag) {
//		if(color[wFlag] == WHITE)
//			wFlag++;
//		else if(color[wFlag] == BLUE) {
//			SWAP(bFlag, wFlag);
//			bFlag++; wFlag++;
//		}
//		else {
//			while(wFlag < rFlag && color[rFlag] == RED)
//				rFlag--;
//			SWAP(rFlag, wFlag);
//			rFlag--;
//		}
//	}
//	for(i = 0; i < strlen(color); i++)
//		printf("%c ", color[i]);
//	printf("\n");
//	return 0;
//}