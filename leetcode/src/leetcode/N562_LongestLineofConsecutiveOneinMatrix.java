package leetcode;

/**
 * Created by Hua on 7/19/2017.

 Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 The line could be horizontal, vertical, diagonal or anti-diagonal.

 Example:

 Input:
 [[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]

 Output: 3

 Hint: The number of elements in the given matrix will not exceed 10,000.

 */
public class N562_LongestLineofConsecutiveOneinMatrix {
    // Google (Premium)
    // DP, use 3D array to store 4 directions, 0 row, 1 col, 2 diagonal, 3 anti-diagonal
    // solved with hint, hint is 3D array to store each direction.
    // 57 / 57 test cases passed.
    // 34 ms
    public class Solution {
        // DP, use 3D array to store 4 directions, 0 row, 1 col, 2 diagonal, 3 anti-diagonal
        // solved with hint, hint is 3D array to store each direction.
        // 57 / 57 test cases passed.
        // 34 ms
        public int longestLine(int[][] M) {
            int row = M.length, col = (row != 0 ? M[0].length : 0);
            int[][][] dp = new int[row+1][col+2][4];
            int ret = 0;
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(M[i][j] == 1){
                        dp[i+1][j+1][0] = 1 + dp[i+1][j][0]; // check row (-)
                        dp[i+1][j+1][1] = 1 + dp[i][j+1][1]; // check col (|)
                        dp[i+1][j+1][2] = 1 + dp[i][j][2];   // check diagonal  (\)
                        dp[i+1][j+1][3] = 1 + dp[i][j+2][3]; // check anti-diagonal  (/)

                        for(int k=0;k<4;k++) ret = Math.max(ret, dp[i+1][j+1][k]);
                    }
                }
            }
            return ret;
        }
    }
}
