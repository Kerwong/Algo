package com;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * */

public class Solution {
	
	public String intToRoman(int num) {
        String retStr = "";
        
        for (int i=4; i > 0; i--) {
        	retStr += digitTransf((int) (num/Math.pow(10, i-1)), i);
        	num = (int) (num % Math.pow(10, i-1));
        }
        
        return retStr;
    }
	
	private String digitTransf(int x, int pos) {
		String ret = "";
		
		if (pos > 4 || pos < 1)
			return null;
		else {
			if (pos == 1)
				switch (x) {
				case 1:ret = "I";break;
				case 2:ret = "II";break;
				case 3:ret = "III";break;
				case 4:ret = "IV";break;
				case 5:ret = "V";break;
				case 6:ret = "VI";break;
				case 7:ret = "VII";break;
				case 8:ret = "VIII";break;
				case 9:ret = "IX";break;
				case 0:
				default:ret = "";break;
				}
			if (pos == 2)
				switch (x) {
				case 1:ret = "X";break;
				case 2:ret = "XX";break;
				case 3:ret = "XXX";break;
				case 4:ret = "XL";break;
				case 5:ret = "L";break;
				case 6:ret = "LX";break;
				case 7:ret = "LXX";break;
				case 8:ret = "LXXX";break;
				case 9:ret = "XC";break;
				case 0:
				default:ret = "";break;
				}
			if (pos == 3)
				switch (x) {
				case 1:ret = "C";break;
				case 2:ret = "CC";break;
				case 3:ret = "CCC";break;
				case 4:ret = "CD";break;
				case 5:ret = "D";break;
				case 6:ret = "DC";break;
				case 7:ret = "DCC";break;
				case 8:ret = "DCCC";break;
				case 9:ret = "CM";break;
				case 0:
				default:ret = "";break;
				}
			if (pos == 4)
				switch (x) {
				case 1:ret = "M";break;
				case 2:ret = "MM";break;
				case 3:ret = "MMM";break;
				case 0:
				default:ret = "";break;
				}
		}
		
		return ret;
	}
}
