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

 isMatch("aab", "a*b") ? true
 isMatch("aaab", "a*b") ? true
 isMatch("aaaab", "a*b") ? true

 isMatch("a", "a**") ? false
 isMatch("", "**") ? true

 */
public class N10_RegularExpressionMatching {
    // google, facebook
    // recursive
    // 445 / 445 test cases passed.  on 9/22/2017
    // 140 ms
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();
            boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));  // match first

            if (p.length() >= 2 && p.charAt(1) == '*'){                  // has star
                return (isMatch(s, p.substring(2))                       // star match 0 char
                        || (first_match && isMatch(s.substring(1), p))); // star match 1 char, and continue to match
            } else {
                return first_match && isMatch(s.substring(1), p.substring(1));  // no star, regular one-to-one match
            }
        }
    }



    // 445 / 445 test cases passed.  on 8/15/2017
    // 174 ms
    public class Solution2 {
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



    // DP
    /*

    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
               here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

     */

    // 445 / 445 test cases passed.  on 9/22/2017
    // 29 ms
    class Solution3 {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i-1]) {
                    dp[0][i+1] = true;
                }
            }
            for (int i = 0 ; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                        dp[i+1][j+1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                            dp[i+1][j+1] = dp[i+1][j-1];
                        } else {
                            dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
