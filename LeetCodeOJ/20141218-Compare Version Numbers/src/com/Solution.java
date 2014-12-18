package com;

/**
 * Compare two version numbers version1 and version1. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0. You may
 * assume that the version strings are non-empty and contain only digits and the
 * . character. The . character does not represent a decimal point and is used
 * to separate number sequences. For instance, 2.5 is not "two and a half" or
 * "half way to version three", it is the fifth second-level revision of the
 * second first-level revision. Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37 Credits: Special thanks to @ts for adding this
 * problem and creating all test cases.
 * */

/* SOLUTION 1:
 * 题目理解错误*/
/*
public class Solution {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");	// 正则中注意 . 为任意字符，需转义
		String[] v2 = version2.split("\\.");
		
		int ret = 0;
		if (v1.length == 1 && v2.length == 1) {	// "1" 这种字符串 split，结果为 {"1"}，长度为 1，而不是 0
			return compareNumber(version1, version2);
		} else if (v1.length == 1 && v2.length != 1) {
			 ret = compareNumber(version1, v2[0]);
			 if (ret == 0 && !v2[1].equals("0")) return -1;	// 1.0 与 1 相等
			 else return 0;
		} else if (v1.length != 1 && v2.length == 1) {
			ret = compareNumber(v1[0], version2);
			if (ret == 0 && !v1[1].equals("0")) return 1;
			else return 0;
		} else {
			ret = compareNumber(v1[0], v2[0]);
			if (ret == 0) {
				return compareNumber(v1[1], v2[1]);
			} else {
				return ret;
			}
		}
	}
	
	private int compareNumber(String x, String y) {
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		if (xx > yy) {
			return 1;
		} else if (xx < yy) {
			return -1;
		} else {
			return 0;
		}
	}
}
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int i = 0;
		int ret = 0;
		while (true) {
			if (i < v1.length && i < v2.length) {
				ret = compareNumber(v1[i], v2[i]);
				if (ret != 0) {
					return ret;
				}
			} else if (i == v1.length && i < v2.length) {
				if (!v2[i].equals("0")) {
					return -1;
				} else {
					return 0;
				}
			} else if (i != v1.length && i == v2.length) {
				if (!v1[i].equals("0")) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
			i++;
		}
    }
    
    private int compareNumber(String x, String y) {
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		if (xx > yy) {
			return 1;
		} else if (xx < yy) {
			return -1;
		} else {
			return 0;
		}
	}
}