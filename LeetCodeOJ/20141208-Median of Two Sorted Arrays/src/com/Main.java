package com;

public class Main {

<<<<<<< HEAD
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		int [] A = {1,3,4,5,6};
		int [] B = {2,3,4,7,8,9};
		
		double ret = solution.findMedianSortedArrays(A, B);
	}
=======
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		int[] numbers = { 1, 2, 3, 4, 5, 7, 9 };
		sol.findMedianSortedArrays(numbers, numbers);
	}

>>>>>>> 78bdbdcf490c5567a63f85b073624b47fa42cffe
}
