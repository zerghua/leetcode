package leetcode;

/**
 A robot is located at the top-left corner of a m x n grid
 (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 (marked 'Finish' in the diagram below).

 Note: m and n will be at most 100.

 How many possible unique paths are there?
 */
public class N62_UniquePaths {
    //1 ms
    public int uniquePaths2(int m, int n) {
        // corner cases
        if(m< 1 || n< 1) return 0;
        if(m==1 || n==1) return 1;

        int[][] map = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n;j++){
                if(i==1 || j==1) map[i][j] = 1;
                else map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m][n];
    }

    //Time Limit Exceeded, should work for small numbers
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 0;
        if(m==1) return 1;
        if(n==1) return 1;
        return uniquePaths(m-1, n) +  uniquePaths(m, n-1);
    }

    // version 2 added on 9/9/2016
    // 2-d DP. Easy.  dp[i][j] = dp[i-1][j] + dp[i][j-1]
    // 1 ms  61 / 61 test cases passed.
    public class Solution {
        public int uniquePaths(int m, int n) {
            if(m<=0 || n<=0) return 0;
            int[][] dp = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0 || j==0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }

    // rolling 1D array added on 10/16/2016
    // 1 ms 61 / 61 test cases passed.
    public class Solution2 {
        public int uniquePaths(int m, int n) {
            if(m<=0 || n<=0) return 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i=0;i<m;i++){
                for(int j=1;j<n;j++){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
            return dp[n-1];
        }
    }
}
