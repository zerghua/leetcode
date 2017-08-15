package leetcode;

/**
 * Created by Hua on 5/7/2016.
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true,       .* could be .. and then it can match ab.
 isMatch("aab", "c*a*b") ? true

 */
public class N10_RegularExpressionMatching {
    // google, facebook
    // recursive
    // 445 / 445 test cases passed.  on 8/15/2017
    // 174 ms
    public class Solution {
        public boolean isMatch(String s, String p) {
            if(p.length() == 0) return s.length() == 0;

            // special case p.length == 1 or p's second char is NOT *
            if(p.length() == 1 || p.charAt(1) != '*'){
                if(s.length() ==0 || (p.charAt(0) != '.' && p.charAt(0)!=s.charAt(0))) return false;
                return isMatch(s.substring(1), p.substring(1));
            }else {
                int len = s.length();
                int i = -1;
                while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                    if (isMatch(s.substring(i + 1), p.substring(2))) return true;
                    i++;
                }
                return false;
            }
        }
    }

    //TODO DP
}
