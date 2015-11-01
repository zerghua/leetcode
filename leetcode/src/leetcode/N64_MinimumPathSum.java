package leetcode;

/**
 Given a m x n grid filled with non-negative numbers,
 find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class N64_MinimumPathSum {
    //DP 4 ms 56%  space O(col*row)
    public int minPathSum(int[][] grid) {
        if(grid ==null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] map = new int[row][col];

        // top left corner
        map[0][0] = grid[0][0];

        // first row
        for(int i=1;i<col; i++) map[0][i] = map[0][i-1] + grid[0][i];

        // first col
        for(int i=1;i<row; i++) map[i][0] = map[i-1][0] + grid[i][0];

        // others
        for(int i=1;i< row; i++){
            for(int j=1;j<col;j++){
                map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + grid[i][j];
            }
        }

        return map[row-1][col-1];
    }

    // DP space O(col), 4 ms 56%
    public int minPathSum2(int[][] grid) {
        if(grid ==null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] map = new int[col];

        // top left corner
        map[0] = grid[0][0];

        // first row
        for(int i=1;i<col; i++) map[i] = map[i-1] + grid[0][i];

        // others
        for(int i=1;i< row; i++){
            map[0] +=  grid[i][0]; //first col of each row
            for(int j=1;j<col;j++){
                map[j] = Math.min(map[j], map[j - 1]) + grid[i][j];
            }
        }

        return map[col-1];
    }
}
