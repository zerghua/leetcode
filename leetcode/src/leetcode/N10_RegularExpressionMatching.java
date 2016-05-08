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
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true

 */
public class N10_RegularExpressionMatching {
    // recursive
    // 144 ms
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;

        // special case p.length == 1 and p's second char is NOT *
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() ==0 || (p.charAt(0) != '.' && p.charAt(0)!=s.charAt(0)))
                return false;
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

    //TODO DP
}
