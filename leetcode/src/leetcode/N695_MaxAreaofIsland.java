package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/15/2017.

 Given a non-empty 2D array grid of 0's and 1's,
 an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:

 [
 [0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]
 ]

 Given the above grid, return 6. Note the answer is not 11,
 because the island must be connected 4-directionally.

 Example 2:

 [[0,0,0,0,0,0,0,0]]

 Given the above grid, return 0.

 Note: The length of each dimension in the given grid does not exceed 50.

 */
public class N695_MaxAreaofIsland {
    // my contest solution
    // BFS + DFS
    // 726 / 726 test cases passed.
    // 40 ms
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            int m=grid.length, n = grid[0].length;
            boolean[][] isVisited = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n;j++){
                    max = Math.max(max, dfs(grid, isVisited, i, j));
                }
            }
            return max;
        }

        public int dfs(int[][] grid, boolean[][] isVisited, int i, int j){
            int m=grid.length, n = grid[0].length;
            if(i <0 || i>= m || j<0 || j>=n) return 0;
            if(isVisited[i][j] || grid[i][j] == 0) return 0;
            isVisited[i][j] = true;

            return 1 + dfs(grid,isVisited, i+1,j) + dfs(grid,isVisited, i-1,j) +
                    dfs(grid,isVisited, i,j+1) + dfs(grid,isVisited, i,j-1);
        }
    }
}
