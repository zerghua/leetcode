package leetcode;

import java.math.BigInteger;

/**
 * Created by Hua on 4/10/2016.

 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:

 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.



 */
public class N43_MultiplyStrings {
    //21 ms
    public String multiply(String num1, String num2) {
        BigInteger a= new BigInteger(num1);
        BigInteger b= new BigInteger(num2);
        return a.multiply(b).toString();
    }

    // 9 ms
    // the solution OJ wants
    // the hard part is to understand the problem and code it.
    public String multiply2(String num1, String num2) {
        int n = num1.length() + num2.length();
        int[] ret = new int[n];
        for(int i = num1.length()-1; i>=0;i--){
            for(int j= num2.length()-1;j>=0;j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
                int p1 = i+j, p2 = i+j+1;
                int sum = product + ret[p2]; // add carry
                ret[p1] += sum /10;
                ret[p2] = sum % 10;
            }
        }

        int i=0;
        while(i<n && ret[i] == 0) i++; // skip leading 0

        StringBuilder sb = new StringBuilder();
        while(i<n) sb.append(ret[i++]);
        return sb.length() ==0? "0": sb.toString();
    }
}
