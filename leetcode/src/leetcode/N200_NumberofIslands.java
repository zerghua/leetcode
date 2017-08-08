package leetcode;

/**
 * Created by Hua on 4/3/2016.

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands
 horizontally or vertically. You may assume all four edges of the grid are
 all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000

 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011

 Answer: 3

 */
    //["111","010","111"]
    // DFS, for each cell, do DFS on adjacent cells, and mark them as visited.
public class N200_NumberofIslands {
    // Google, Facebook, Mircosoft, Amazon
    //dfs, look at how predicate is pushed down, result a cleaner code
    public void dfs(char[][] grid, int i, int j,
                    boolean[][] is_visited_islands, int island_num) {

        is_visited_islands[i][j] = true;
        // up
        if (i - 1 >= 0 && is_visited_islands[i - 1][j] == false && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, is_visited_islands, island_num);
        }
        // bottom
        if (i + 1 < grid.length && is_visited_islands[i + 1][j] == false && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, is_visited_islands, island_num);
        }
        // left
        if ((j - 1 >= 0 && is_visited_islands[i][j-1] == false && grid[i][j - 1] == '1')) {
            dfs(grid, i, j-1, is_visited_islands, island_num);
        }
        // right
        if ((j + 1 < grid[0].length && is_visited_islands[i][j+1] == false && grid[i][j + 1] == '1')) {
            dfs(grid, i, j+1, is_visited_islands, island_num);
        }
    }

    //4 ms
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length==0 ) return 0;
        boolean[][] is_visited_islands = new boolean[grid.length][grid[0].length];
        int islands_num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (is_visited_islands[i][j] == false && grid[i][j] == '1') {
                    islands_num++;
                    dfs(grid, i, j, is_visited_islands, islands_num);
                }
            }
        }
        return islands_num;
    }

    ///////////////////////////////////////////////////////////////////////////
    // better coding, predicate pushdown  4 ms
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length==0 || grid[0].length==0) return 0;
        boolean[][] is_visited_islands = new boolean[grid.length][grid[0].length];
        int islands_num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (is_visited_islands[i][j] == false && grid[i][j] == '1') {
                    islands_num++;
                    dfs2(grid, i, j, is_visited_islands);
                }
            }
        }
        return islands_num;
    }

    public void dfs2(char[][] grid, int i, int j,
                    boolean[][] is_visited_islands) {

        //boundry checking
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1) return;

        //return if visited or not land.
        if(is_visited_islands[i][j] || grid[i][j] == '0') return;

        is_visited_islands[i][j] = true;

        dfs2(grid, i - 1, j, is_visited_islands);
        dfs2(grid, i + 1, j, is_visited_islands);
        dfs2(grid, i, j - 1, is_visited_islands);
        dfs2(grid, i, j + 1, is_visited_islands);
    }

}
