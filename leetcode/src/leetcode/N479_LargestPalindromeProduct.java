package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Find the largest palindrome made from the product of two n-digit numbers.

 Since the result could be very large, you should return the largest palindrome mod 1337.

 Example:

 Input: 2

 Output: 987

 Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

 Note:

 The range of n is [1,8].

 */
public class N479_LargestPalindromeProduct {
    // Yahoo
    // 8 / 8 test cases passed.
    // 531 ms
    public class Solution {
        public int largestPalindrome(int n) {
            if(n == 1) return 9;
            int max = (int)Math.pow(10, n) - 1;
            for(int i= max - 1; i> max / 10; i--){
                // build candidate decreasingly, has to use append, or put i in constructor not working
                long candidate = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());

                // check if this candidate can be the product of two number
                for(long j = max; j*j >= candidate ;j--){ // j has be long
                    if(candidate % j == 0) return (int)(candidate % 1337);
                }
            }
            return 0;
        }
    }
}
