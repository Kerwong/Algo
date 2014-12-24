package com;

/**
<<<<<<< HEAD
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * */

public class Solution {
	
	/********** Solution ONE ***********/
	public double findMedianSortedArrays(int A[], int B[]) {
		int [] mergedArray = mergeSortedArrays(A, B);
		/* WARNING:
		 * odd elements in mergedArray, 
		 * the median is mergedArray.length/2*/
		if (mergedArray.length % 2 == 1) {
			return mergedArray[mergedArray.length/2];
		} else {
			/* WARNING:
			 * even elements in mergedArray,
			 * notice the array is empty*/
			if (mergedArray.length == 0) {
				return 0.0;
			}
			int mid = mergedArray.length/2 - 1;
			double res = mergedArray[mid] + mergedArray[mid + 1];
			/* WARNING:
			 * notice mergedArray[] are integer,
			 * if integer plus integer and divide 2, 
			 * the result will be an Integer, 
			 * However we need to return a double*/
			return res/2;
		}
    }
	
=======
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int[] mergedArray = mergeSortedArrays(A, B);

		if (mergedArray.length % 2 == 1) {
			return mergedArray[mergedArray.length / 2];
		} else {
			if (mergedArray.length == 0) {
				return 0.0;
			}
			int mid = mergedArray.length / 2 - 1;
			double res = mergedArray[mid] + mergedArray[mid + 1];
			return res / 2;
		}
	}

>>>>>>> 78bdbdcf490c5567a63f85b073624b47fa42cffe
	/* Merge two sorted array */
	private int[] mergeSortedArrays(int A[], int B[]) {
		int count = A.length + B.length;
		int[] mergedArray = new int[count];
<<<<<<< HEAD
		
		int i = 0, j = 0, x = 0;
		/* WARNING:
		 * when merging, notice add all A's elements, 
		 * and still has some B's elements, so need to traverse B*/
=======

		int i = 0, j = 0, x = 0;
>>>>>>> 78bdbdcf490c5567a63f85b073624b47fa42cffe
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				mergedArray[x++] = A[i++];
			} else {
				mergedArray[x++] = B[j++];
			}
		}
<<<<<<< HEAD
		
		if(i == A.length){
=======

		if (i == A.length) {
>>>>>>> 78bdbdcf490c5567a63f85b073624b47fa42cffe
			while (j < B.length) {
				mergedArray[x++] = B[j++];
			}
		} else {
			while (i < A.length) {
				mergedArray[x++] = A[i++];
			}
		}
		return mergedArray;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 78bdbdcf490c5567a63f85b073624b47fa42cffe
