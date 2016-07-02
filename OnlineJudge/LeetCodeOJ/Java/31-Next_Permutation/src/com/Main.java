package com;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		int [] A = {5,1,1};
		int [] B = {2,3,4,7,8,9};
		
		solution.nextPermutation(A);
		
		System.out.println(A.toString());
	}
}
