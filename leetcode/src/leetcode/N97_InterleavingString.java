package leetcode;

/**
 * Created by Hua on 5/5/2016.
 *
 *  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class N97_InterleavingString {
    // no company
    // 11 ms
    // 2-d dp
    // time o(mn)
    // space o(mn)
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        // empty string
        dp[0][0] = true;

        // s2 is empty
        for(int i=1; i<=s1.length();i++){
            if(s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = dp[i-1][0];
        }

        // s1 is empty
        for(int i=1; i<=s2.length();i++){
            if(s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = dp[0][i-1];
        }

        // the rest
        for(int i=1; i<=s1.length();i++){
            char c1 = s1.charAt(i-1);
            for(int j=1; j<=s2.length();j++){
                char c2= s2.charAt(j-1);
                char c3= s3.charAt(i+j-1);

                if(c1 == c3) dp[i][j] = dp[i-1][j];
                if(c2 == c3) dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
