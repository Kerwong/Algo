package com;

import java.util.Vector;

/**
 * Given a positive integer, 
 * return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * 
 */

public class Solution {
	/** SOLUTION 1 */
	public String convertToTitle(int n) {
        Vector<Character> temp = new Vector<>();
        
        while (n != 0) {
        	n--;
			temp.add((char) ('A' + n % 26));
			n = n / 26;
		}
        
        String resString = "";
		for (int j = temp.size() - 1; j >= 0; j--) {
			resString += temp.elementAt(j);
		}
		
		return resString;
    }
}