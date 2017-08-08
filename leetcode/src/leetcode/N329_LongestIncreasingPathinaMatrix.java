package leetcode;

/**
 * Created by Hua on 5/25/2017.

 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down.
 You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
     [9,9,4],
     [6,6,8],
     [2,1,1]
 ]

 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
     [3,4,5],
     [3,2,6],
     [2,2,1]
 ]

 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */
public class N329_LongestIncreasingPathinaMatrix {
    // Google
    // DFS + memo
    // 137 / 137 test cases passed.
    // 26 ms
    public class Solution {
        int ret = 0;
        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;
            int row = matrix.length, col = matrix[0].length;
            int[][] memo = new int[row][col];
            for(int i=0;i<row; i++){
                for(int j=0;j<col;j++){
                    ret = Math.max(ret, dfs(matrix, memo, i, j, null));
                }
            }
            return ret;
        }

        public int dfs(int[][] matrix, int[][] memo, int i, int j, Integer lastVal){
            int row = matrix.length, col = matrix[0].length;
            if(i<0 || i>=row || j<0 || j>= col) return 0;
            int max = 0;
            if(lastVal == null || matrix[i][j] > lastVal){
                if(memo[i][j] > 0) return memo[i][j];
                max = Math.max(max, 1 + dfs(matrix, memo, i+1, j, matrix[i][j]));
                max = Math.max(max, 1 + dfs(matrix, memo, i-1, j, matrix[i][j]));
                max = Math.max(max, 1 + dfs(matrix, memo, i, j+1, matrix[i][j]));
                max = Math.max(max, 1 + dfs(matrix, memo, i, j-1, matrix[i][j]));
            }

            memo[i][j] = max;
            return max;
        }
    }


    // slight code improvement
    // 137 / 137 test cases passed.
    // 22 ms
    public class Solution2 {
        int[][] dirs = {{1,0}, {-1,0}, {0,1},{0,-1}};
        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;
            int row = matrix.length, col = matrix[0].length, ret = 0;;
            int[][] memo = new int[row][col];
            for(int i=0;i<row; i++){
                for(int j=0;j<col;j++){
                    ret = Math.max(ret, dfs(matrix, memo, i, j));
                }
            }
            return ret;
        }

        public int dfs(int[][] matrix, int[][] memo, int i, int j){
            if(memo[i][j] > 0) return memo[i][j];
            int row = matrix.length, col = matrix[0].length, max = 1; // max has to 1, not always trigger dfs here
            for(int[] dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                if(x<0 || x>=row || y<0 || y>= col || matrix[x][y] <= matrix[i][j]) continue;
                max = Math.max(max, 1 + dfs(matrix, memo, x, y));
            }

            memo[i][j] = max;
            return max;
        }
    }
}
