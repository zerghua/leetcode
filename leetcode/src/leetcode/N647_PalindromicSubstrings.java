package leetcode;

/**
 * Created by Hua on 8/1/2017.

 Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different
 substrings even they consist of same characters.

 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".

 Example 2:

 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 Note:

 The input string length won't exceed 1000.

 */
public class N647_PalindromicSubstrings {
    // Linkedin
    // String, similar to N5_LongestPalindromicSubstring
    // 130 / 130 test cases passed.
    // 11 ms
    public class Solution {
        public int countSubstrings(String s) {
            int ret = 0, n = s.length();
            for(int i=0; i<n; i++){
                ret += count(s, i, i);
                ret += count(s, i, i+1);
            }
            return ret;
        }

        public int count(String s, int i, int j){
            int n = s.length(), ret = 0;
            while(i >=0 && j<n){
                if(s.charAt(i) != s.charAt(j)) break;
                ret++;
                i--; j++;
            }
            return ret;
        }
    }
}
