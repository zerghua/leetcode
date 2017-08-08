package leetcode;

/**
 * Created by HuaZ on 11/17/2016.

 Given a non-empty string check if it can be constructed by taking a substring of it
 and appending multiple copies of the substring together. You may assume the given string
 consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:

 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.

 Example 2:

 Input: "aba"

 Output: False

 Example 3:

 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


 */
public class N459_RepeatedSubstringPattern {
    // Amazon, Google
    // 63 ms 100 / 100 test cases passed.
    // String, o(n^2)
    public class Solution {
        public boolean repeatedSubstringPattern(String str) {
            int size = str.length();
            for(int i=size/2;i>=1;i--) {
                if (size % i == 0) {
                    String sub = str.substring(0, i);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < size / i; j++) sb.append(sub);
                    if (sb.toString().equals(str)) return true;
                }
            }
            return false;
        }
    }
}
