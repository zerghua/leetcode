package leetcode;

import java.util.LinkedList;

/**
 * Created by Hua on 5/5/2017.

 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 The distance between two adjacent cells is 1.

 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0

 Output:

 0 0 0
 0 1 0
 0 0 0

 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1

 Output:

 0 0 0
 0 1 0
 1 2 1

 Note:

 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.


 */
public class N542_01Matrix {
    // BFS, enqueue all 0, and process from them
    // 48 / 48 test cases passed.
    // 47 ms
    public class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;
            LinkedList<int[]> q = new LinkedList();
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(matrix[i][j] == 0) q.add(new int[]{i, j});
                    else matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // smart
            while(!q.isEmpty()){
                int[] zeroCell = q.removeFirst();
                for(int[] dir: dirs){
                    int r = zeroCell[0] + dir[0];
                    int c = zeroCell[1] + dir[1];
                    if(r < 0 || r >= row || c < 0 || c >= col || matrix[r][c] <= matrix[zeroCell[0]][zeroCell[1]] + 1)
                        continue;
                    matrix[r][c] = matrix[zeroCell[0]][zeroCell[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }
            return matrix;
        }
    }
}
