package com;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		

		//int[] A = {7,10,12,15,0,1,3,4,6};
		char[][] A = new char[9][9];
		A[0] = ".87654321".toCharArray();
		A[1] = "2........".toCharArray();
		A[2] = "3........".toCharArray();
		A[3] = "4........".toCharArray();
		A[4] = "5........".toCharArray();
		A[5] = "6........".toCharArray();
		A[6] = "7........".toCharArray();
		A[7] = "8........".toCharArray();
		A[8] = "9........".toCharArray();
		
		solution.isValidSudoku(A);
		
	}
}
