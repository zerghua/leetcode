package leetcode;

/**
 * Created by Hua on 6/15/2017.

 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 where in each step you can delete one character in either string.

 Example 1:

 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

 Note:

 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.


 illustration:
   ^ S E A
 ^ 0 0 0 0
 E 0 0 1 1
 A 0 0 1 2
 T 0 0 1 2


 */
public class N583_DeleteOperationforTwoStrings {
    // Google
    // this is equivalent to Longest Common Subsequence(LCS)
    // 1307 / 1307 test cases passed.
    // 70 ms
    public class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<=m ; i++){
                for(int j=0; j<=n ; j++){
                    if(i == 0 || j==0) dp[i][j] = 0;
                    else{
                        dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return m + n - 2*dp[m][n];
        }
    }
}
