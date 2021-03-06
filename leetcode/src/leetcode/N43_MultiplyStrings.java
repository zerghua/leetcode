package leetcode;

import java.math.BigInteger;

/**
 * Created by Hua on 4/10/2016.

 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:

 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.

 version 2 added on 9/4/2016
 the hard part is to understand the problem and code it.
 be careful with carry and leading zeros.
 */
public class N43_MultiplyStrings {
    // Facebook, Twitter
    // 311 / 311 test cases passed.
    // 32 ms
    // the solution OJ wants
    public class Solution {
        public String multiply(String num1, String num2) {
            int n = num1.length() + num2.length();
            int[] ret = new int[n];
            for(int i = num1.length()-1; i>=0;i--){
                for(int j= num2.length()-1;j>=0;j--){
                    int product = (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
                    int hi = i+j, low = i+j+1;
                    int sum = product + ret[low]; // add carry
                    ret[hi] += sum /10;
                    ret[low] = sum % 10;
                }
            }

            int i=0;
            while(i<n && ret[i] == 0) i++; // skip leading 0

            StringBuilder sb = new StringBuilder();
            while(i<n) sb.append(ret[i++]);
            return sb.length() ==0? "0": sb.toString();
        }
    }

    //21 ms
    public String multiply(String num1, String num2) {
        BigInteger a= new BigInteger(num1);
        BigInteger b= new BigInteger(num2);
        return a.multiply(b).toString();
    }
}
