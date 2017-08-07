package leetcode;

/**
 * Created by Hua on 3/26/2016.

 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 */
public class N63_UniquePaths2 {
    // Bloomberg
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows= obstacleGrid.length;
        int cols= obstacleGrid[0].length;

        int[][] ret = new int[rows][cols];
        if(obstacleGrid[0][0] == 1) return 0;
        else ret[0][0] = 1;

        //first row
        for(int i=1;i<cols;i++){
            if(obstacleGrid[0][i] ==1) ret[0][i] = 0;
            else ret[0][i] = ret[0][i-1];
        }

        //first cols
        for(int i=1;i<rows;i++){
            if(obstacleGrid[i][0] ==1) ret[i][0] = 0;
            else ret[i][0] = ret[i-1][0];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j] == 1) ret[i][j]=0;
                else  ret[i][j] = ret[i-1][j] + ret[i][j-1];

            }
        }

        return ret[rows-1][cols-1];
    }

    // version 2 added on 9/9/2016
    // medium, 1-d DP.
    // 1ms 43 / 43 test cases passed.
    public class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            int[] dp = new int[col];
            if(obstacleGrid == null || row==0 || obstacleGrid[0][0]==1)
                return 0;

            dp[0] = 1;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(obstacleGrid[i][j] == 1) dp[j] = 0;
                    else if(j>0) dp[j] += dp[j-1];
                }
            }
            return dp[col-1];
        }
    }


}
