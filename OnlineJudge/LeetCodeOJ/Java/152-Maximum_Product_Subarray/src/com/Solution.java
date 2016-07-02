package com;


/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
	/** SOLUTION 1 */
    public int maxProduct(int[] A) {
        int maxproduct = A[0];
        int minproduct = A[0];
        
        int curpro = A[0];
        for (int i = 1; i < A.length; i++) {
        	curpro = curpro * A[i];
        	if (A[i] != 0) {        		
        		maxproduct = Math.max(maxproduct, Math.max(curpro, A[i]));
        		minproduct = Math.min(minproduct, Math.min(curpro, A[i]));
			} else {
				if (maxproduct < 0) {
					maxproduct = 0;
				}
				curpro = 1;				
			}
		}
        return maxproduct;
    }
}