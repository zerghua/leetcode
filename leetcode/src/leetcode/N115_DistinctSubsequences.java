package leetcode;

/**
 * Created by Hua on 6/20/2016.

 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.

 http://blog.csdn.net/abcbc/article/details/8978146
 */
public class N115_DistinctSubsequences {
    // 21 ms
    // two string, 2-d dp.
    // dp[i][j] = dp[i-1][j]
    // if(s.charAt(i) == t.chatAt(j)) dp[i][j] += dp[i-1][j-1]
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) dp[i][0] = 1;

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[s.length()][t.length()];
    }
}
