package leetcode;

/**
 * Created by HuaZ on 10/4/2016.

 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true

 Note: It is intended for the problem statement to be ambiguous.
 You should gather all requirements up front before implementing one.

 extra test case:
 "e9" => false
 "0e" => false
 should match
 [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

 */


public class N65_ValidNumber {
    // added on 10/4/2016
    // 3 ms 1481 / 1481 test cases passed.
    public class Solution {
        int i=0;
        public boolean hasInt(char[] a, int n){
            boolean hasNumber=false;
            while(i<n && '0'<= a[i] && a[i] <='9') {
                i++;
                hasNumber=true;
            }
            return hasNumber;
        }

        public boolean hasDecimal(char[] a, int n){
            // check digits
            boolean hasNumber= hasInt(a, n);

            // check points and digits
            if(i<n && a[i] == '.'){
                i++;
                hasNumber = hasInt(a, n) || hasNumber;
            }
            return hasNumber;
        }

        public boolean isNumber(String s) {
            // first skip white space
            int n = s.length();
            char[] a = s.toCharArray();
            while(i<n && a[i] == ' ') i++;

            // check sign
            if(i<n && (a[i] == '+' || a[i] == '-'))i++;
            boolean hasNumber = hasDecimal(a, n);

            // check e
            boolean hasE = false;
            if(i<n && a[i] == 'e' && hasNumber) {
                hasE = true;
                i++;
            }
            // if has e, it should have numbers after it.
            if(hasE) {
                if(i<n && (a[i] == '+' || a[i] == '-'))i++;
                hasNumber = hasInt(a, n);
            }

            // trailing zeros
            while(i<n && a[i] == ' ') i++;
            return hasNumber && i == n;
        }
    }
}
