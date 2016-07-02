package com;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is 
 * at (i, ai) and (i, 0). Find two lines, which together with x-axis forms 
 * a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * */

/** WARNING:
 * 注意，仅需要找到两端的板子就可以了，可以无视中间的板子*/
public class Solution {
	public int maxArea(int[] height) {
		int maxArea = 0;
		
		int left = 0;
		int right = height.length - 1;
		
		int tmpArea = 0;
		while (left < right) {
			
			tmpArea = Math.min(height[left], height[right]) * (right - left);
			
			if (tmpArea > maxArea)
				maxArea = tmpArea;
			
			if (height[left] <= height[right])
				left++;
			else
				right--;
		}
        return maxArea;
    }
}
