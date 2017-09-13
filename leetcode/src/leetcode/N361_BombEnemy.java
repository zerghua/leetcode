package leetcode;

/**
 * Created by Hua on 7/19/2017.

 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall
 since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:

 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)

 */
public class N361_BombEnemy {
    // Google (Premium)
    // 47 / 47 test cases passed.
    // 62 ms
    // kind of dp, update col and row count when hit wall.
    public class Solution {
        public int maxKilledEnemies(char[][] grid) {
            int row = grid.length, col = (row != 0 ? grid[0].length : 0);  //smart
            int ret = 0, rowHits = 0;
            int[] colHits = new int[col];
            for(int i=0; i< row; i++){
                for(int j=0; j< col; j++){

                    // first col or left is Wall, search right stop until hit wall
                    if(j == 0 || grid[i][j-1] == 'W'){
                        rowHits = 0;
                        for(int k = j; k< col && grid[i][k] != 'W'; k++) rowHits += (grid[i][k] == 'E' ? 1 : 0);
                    }

                    // first row or top is wall, search bottom stop until hit wall
                    if(i == 0 || grid[i-1][j] == 'W'){
                        colHits[j] = 0;
                        for(int k = i; k< row && grid[k][j] != 'W'; k++) colHits[j] += (grid[k][j] == 'E' ? 1 : 0);
                    }

                    if(grid[i][j] == '0') ret = Math.max(ret, rowHits + colHits[j]);
                }
            }
            return ret;
        }
    }
}
