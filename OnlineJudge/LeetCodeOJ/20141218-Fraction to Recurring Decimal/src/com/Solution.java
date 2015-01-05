package com;

import java.math.BigInteger;
import java.util.HashMap;


/**
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
        String resString = "";
        
        if (Integer.signum(numerator) * Integer.signum(denominator) == -1) {
			resString += "-";
		}
        
        BigInteger num = new BigInteger(String.valueOf(numerator));
        num = num.abs();
        BigInteger den = new BigInteger(String.valueOf(denominator));
        den = den.abs();	// Integer.MIN_VALUE 通过 abs，变为 1
        
        // integer part
        resString += String.valueOf(num.divide(den).abs());
        
        if (0 == numerator % denominator) {
			return resString;
		}
        
        // decimal part
        resString += ".";
        
        HashMap<BigInteger, Integer> remainderMap = new HashMap<>();
        
        String decString = "";
        int precision = 0;
        
        BigInteger r = new BigInteger(String.valueOf(numerator % denominator));
        r = r.abs();
        remainderMap.put(r, precision);
        while (!r.equals(BigInteger.ZERO)) {
        	precision++;
        	num = r.multiply(BigInteger.valueOf(10));
        	r = num.mod(den);
        	
        	BigInteger p = num.divide(den);
        	decString += String.valueOf(p.abs());
        	
        	// 比较求余时，余数是否重复，若重复，说明循环开始
        	if (remainderMap.containsKey(r)) {
				break;
			} else {
				remainderMap.put(r, precision);
			}
		}
        
        if (r.equals(BigInteger.ZERO)) {
        	return resString + decString;
		}
        
        int repeatIndex = remainderMap.get(r);
        String nonrepeatPart = decString.substring(0, repeatIndex);
        String repeatPart = decString.substring(repeatIndex, precision);
        return resString + nonrepeatPart + "(" + repeatPart + ")";
    }
	
}