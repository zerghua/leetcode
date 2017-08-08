package leetcode;

/**
 * Created by Hua on 6/13/2017.

 Given an integer n, find the closest integer (not including itself), which is a palindrome.

 The 'closest' is defined as absolute difference minimized between two integers.

 Example 1:

 Input: "123"
 Output: "121"

 Note:

 The input n is a positive integer represented by string, whose length will not exceed 18.
 If there is a tie, return the smaller one as answer.


 */
public class N564_FindtheClosestPalindrome {
    // Yelp
    // hard. find the first half and build two possible palindrome and compare.
    // there are quite a few corner cases.
    // 212 / 212 test cases passed.
    // 21 ms
    public class Solution {
        long num, ret = 0, diff = Long.MAX_VALUE;

        public String nearestPalindromic(String n) {
            num = Long.parseLong(n);
            long leftHalf = Long.parseLong(n.substring(0, (n.length() + 1)/2));
            buildPalindrome(leftHalf);

            buildPalindrome(leftHalf-1);
            buildPalindrome((leftHalf-1) * 10 + 9); // Handle 1, 1000, 100000, etc.  1000 -> 999

            buildPalindrome(leftHalf+1);
            buildPalindrome((leftHalf+1)/10);       // Handle 9, 999, 99999, etc.    999 -> 1001

            return "" + ret;
        }

        public void buildPalindrome(long n){
            String s = "" + n,  rs = new StringBuilder(s).reverse().toString();
            updateRet(s + rs);               // abc -> abccba
            updateRet(s + rs.substring(1));  // abc -> abcba
        }

        public void updateRet(String s){
            if(s.length() > 18) return;
            long candidate = Long.parseLong(s);
            if(candidate == num) return;
            if(Math.abs(num - candidate) < diff || (Math.abs(num - candidate) == diff && candidate < ret)){
                ret = candidate;
                diff = Math.abs(num - candidate);
            }
        }
    }

}
