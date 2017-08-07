package leetcode;

/**
 * Created by Hua on 4/21/2016.

 Given two words word1 and word2, find the minimum number of steps required
 to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character

 */
public class N72_EditDistance {
    // no company
    //18 ms
    // 2-dimensional dp, dp[i][j] determines by its top, left and top-left.
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<=word1.length();i++) dp[i][0] = i;
        for(int i=0;i<=word2.length();i++) dp[0][i] = i;

        for(int i=0;i<word1.length();i++){
            char c1 = word1.charAt(i);
            for(int j=0;j<word2.length();j++){
                char c2 = word2.charAt(j);
                if(c1 == c2) dp[i+1][j+1] = dp[i][j];
                else{
                    int insert = dp[i+1][j] + 1;
                    int delete = dp[i][j+1] + 1;
                    int replace = dp[i][j] + 1;
                    dp[i+1][j+1] = Math.min(Math.min(delete, replace),insert);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
