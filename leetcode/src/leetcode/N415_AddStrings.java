package leetcode;

/**
 * Created by HuaZ on 10/16/2016.

 Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.


 */
public class N415_AddStrings {
    // Google, Airbnb
    // from right to left
    // 32 ms 315 / 315 test cases passed.
    public class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder ret = new StringBuilder();
            int carry = 0, i=num1.length()-1, j=num2.length()-1;
            while(i>=0 || j>=0){
                int sum = carry;
                if(i >= 0) {
                    sum += num1.charAt(i) - '0';
                    i--;
                }
                if(j >= 0) {
                    sum += num2.charAt(j) - '0';
                    j--;
                }
                carry = sum/10;
                sum = sum%10;
                ret.insert(0, sum);
            }
            if(carry>0) ret.insert(0,carry);
            return ret.toString();
        }
    }

}
