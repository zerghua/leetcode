package leetcode;

/**
 * Created by Hua on 5/23/2016.

 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 */
public class N67_AddBinary {
    // Facebook
    // using stringbuilder insert rather than reverse. similar to add one
    // test speed, about the same, slightly slower.
    // 294 / 294 test cases passed.
    // 5 ms
    public class Solution {
        public String addBinary(String a, String b) {
            int i=a.length()-1,j=b.length()-1;
            int carry=0;
            StringBuilder sb = new StringBuilder();
            while(i>=0 || j>=0){
                int sum = carry;
                if(i >= 0) sum += a.charAt(i) - '0';
                if(j >= 0) sum += b.charAt(j) - '0';
                carry = sum/2;
                sum = sum%2;
                sb.insert(0, String.valueOf(sum));
                i--;j--;
            }
            if(carry!=0) sb.insert(0,"1");
            return sb.toString();
        }
    }


    // 4 ms
    // start from end
    // corner case: last carry is 1
    // or we can reverse a and b, start from 0.
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            carry = sum/2;
            sum = sum%2;
            sb.append(String.valueOf(sum));
            i--;j--;
        }
        if(carry!=0) sb.append("1");
        return sb.reverse().toString();
    }


}
