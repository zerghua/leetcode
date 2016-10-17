package leetcode;

/**
 * Created by HuaZ on 10/17/2016.

 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t.
 t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 and you want to check one by one to see if T has its subsequence.
 In this scenario, how would you change your code?

 */
public class N392_IsSubsequence {
    // 18 ms 13 / 13 test cases passed.
    // two pointers.
    public class Solution {
        public boolean isSubsequence(String s, String t) {
            int i=0, j=0;
            char[] a = s.toCharArray(), b = t.toCharArray();
            while(i<a.length && j < b.length){
                if(a[i] == b[j]) i++;
                j++;
            }
            return i == a.length;
        }
    }
    // follow up solution
    // put all t chars in  map<char, list of index for this char>
    // for each char in s, to see if we could find an index in t for that char is larger than t_pre_index.
}
