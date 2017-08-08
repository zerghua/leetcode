package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 12/6/2016.

 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right
 and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
 equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:

 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.

 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).


 */
public class N417_PacificAtlanticWaterFlow {
    // Google
    // 19 ms 113 / 113 test cases passed.
    // DFS
    public class Solution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> ret = new ArrayList();
            if(matrix == null || matrix.length==0) return ret;
            int row = matrix.length, col = matrix[0].length;
            boolean[][] pacific = new boolean[row][col], atlantic = new boolean[row][col];
            // first and last col
            for(int i=0;i<row;i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
                dfs(matrix, atlantic, Integer.MIN_VALUE,i, col-1);
            }

            // first and last row
            for(int i=0;i<col;i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
                dfs(matrix, atlantic, Integer.MIN_VALUE,row-1, i);
            }

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(pacific[i][j] && atlantic[i][j]) ret.add(new int[]{i, j});
                }
            }

            return ret;
        }

        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        public void dfs(int[][] matrix, boolean[][] visited, int preHeight, int x, int y){
            int row = matrix.length, col = matrix[0].length;
            if(x<0 || x>=row || y<0 || y>=col || visited[x][y] || matrix[x][y] < preHeight)
                return;

            visited[x][y] = true;
            for(int[] d : dir){
                dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
            }
        }
    }
}
