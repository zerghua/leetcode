package leetcode;

/**
 * Created by HuaZ on 9/18/2017.

 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:

 Input: "aba"
 Output: True

 Example 2:

 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.

 Note:

 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


 */
public class N680_ValidPalindromeII{
    // my contest 50 solution
    // simple recursion. dfs.
    // 460 / 460 test cases passed.
    // 59 ms
    class Solution {
        public boolean validPalindrome(String s) {
            int i=0, j = s.length()-1;
            while(i<j){
                if(s.charAt(i) == s.charAt(j)) {
                    i++;j--;
                }else return isPal(s, i+1, j) || isPal(s, i, j-1);
            }
            return true;
        }

        public boolean isPal(String s, int i, int j){
            while(i < j){
                if(s.charAt(i) == s.charAt(j)){
                    i++;j--;
                }else return false;
            }
            return true;
        }
    }
}
