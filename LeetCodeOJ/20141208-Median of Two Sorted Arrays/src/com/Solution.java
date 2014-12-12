package com;

/**
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

	/* Merge two sorted array */
	private int[] mergeSortedArrays(int A[], int B[]) {
		int count = A.length + B.length;
		int[] mergedArray = new int[count];

		int i = 0, j = 0, x = 0;
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				mergedArray[x++] = A[i++];
			} else {
				mergedArray[x++] = B[j++];
			}
		}

		if (i == A.length) {
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
}