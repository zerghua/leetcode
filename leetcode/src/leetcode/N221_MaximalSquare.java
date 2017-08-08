package leetcode;

/**
 * Created by Hua on 6/13/2016.

 Given a 2D binary matrix filled with 0's and 1's,
 find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Return 4.

 */
public class N221_MaximalSquare {
    // Apple, Facebook
    //15 ms
    // DP:   dp[i][j] = 1+ min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
    public int maximalSquare(char[][] matrix) {
        if(matrix ==null || matrix.length==0) return 0;
        int ret = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] state = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == '1') {
                    if(i==0){  // first row
                        state[0][j] = 1;
                        ret = Math.max(ret, state[0][j]);
                    }else if(j==0){ // first col
                        state[i][0] = 1;
                        ret = Math.max(ret, state[i][0]);
                    }else {
                        state[i][j] = 1 + Math.min(state[i - 1][j - 1],
                                Math.min(state[i - 1][j], state[i][j - 1]));
                        ret = Math.max(ret, state[i][j]);
                    }
                }
            }
        }
        return ret*ret;
    }

    // version 2,3  added on 9/21/2016
    // 16 ms  67 / 67 test cases passed.
    public class Solution2 {
        public int maximalSquare(char[][] matrix) {
            if(matrix ==null || matrix.length==0) return 0;
            int ret = 0;
            int rows = matrix.length, cols = matrix[0].length;
            int[][] state = new int[rows][cols];

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(matrix[i][j] == '1') {
                        if(i==0)  state[0][j] = 1;   //first row
                        else if(j==0) state[i][0] = 1;  // first col
                        else {
                            state[i][j] = 1 + Math.min(state[i - 1][j - 1], Math.min(state[i - 1][j], state[i][j - 1]));
                        }
                        ret = Math.max(ret, state[i][j]);
                    }
                }
            }
            return ret*ret;
        }
    }


    // 10 ms  67 / 67 test cases passed.
    // dummy first row/col makes code looks cleaner.
    public class Solution3 {
        public int maximalSquare(char[][] matrix) {
            if(matrix ==null || matrix.length==0) return 0;
            int ret = 0;
            int rows = matrix.length, cols = matrix[0].length;
            int[][] state = new int[rows+1][cols+1];

            for(int i=1;i<=rows;i++){
                for(int j=1;j<=cols;j++){
                    if(matrix[i-1][j-1] == '1') {
                        state[i][j] = 1 + Math.min(state[i - 1][j - 1], Math.min(state[i - 1][j], state[i][j - 1]));
                        ret = Math.max(ret, state[i][j]);
                    }
                }
            }
            return ret*ret;
        }
    }


}
