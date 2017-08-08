package leetcode;

/**
 * Created by HuaZ on 10/16/2016.

 Given a string which consists of lowercase or uppercase letters,
 find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.


 */
public class N409_LongestPalindrome {
    // Google
    // longest = sum(even count) + sum(odd count-1) + 1(if has odd)
    // 10 ms 95 / 95 test cases passed.
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for(char c: s.toCharArray()) map[c]++;

        int ret = 0;
        boolean hasOdd = false;
        for(int i=0;i<128;i++){
            if(map[i] % 2 == 0) ret += map[i];
            else {
                ret += map[i]-1;
                hasOdd = true;
            }
        }
        return hasOdd? ret + 1: ret;
    }
}
