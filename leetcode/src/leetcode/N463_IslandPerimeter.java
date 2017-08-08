package leetcode;

/**
 * Created by HuaZ on 11/20/2016.

 You are given a map in form of a two-dimensional integer grid
 where 1 represents land and 0 represents water. Grid cells are connected
 horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 and there is exactly one island (i.e., one or more connected land cells).
 The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:


 https://discuss.leetcode.com/topic/68786/clear-and-easy-java-solution

 */
public class N463_IslandPerimeter {
    // Google
    // 126 ms 5833 / 5833 test cases passed.
    // find pattern, math?
    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int island = 0, neighbour = 0;
            int row = grid.length, col = grid[0].length;
            for(int i=0;i<row;i++){
                for(int j=0;j<col; j++){
                    if(grid[i][j] == 1){
                        island++;
                        if(j< col-1 && grid[i][j+1] == 1) neighbour++;
                        if(i< row-1 && grid[i+1][j] == 1) neighbour++;
                    }
                }
            }
            return island*4 - neighbour*2;
        }
    }
}
