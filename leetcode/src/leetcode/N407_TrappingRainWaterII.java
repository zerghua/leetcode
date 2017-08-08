package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Hua on 5/24/2017.

 Given an m x n matrix of positive integers representing the height of each unit Cell in a 2D elevation map,
 compute the volume of water it is able to trap after raining.

 Note:
 Both m and n are less than 110. The height of each unit Cell is greater than 0 and is less than 20,000.

 Example:

 Given the following 3x6 height map:
 [
     [1,4,3,1,3,2],
     [3,2,1,3,2,4],
     [2,3,3,2,3,1]
 ]

 Return 4.

 */
public class N407_TrappingRainWaterII {
    // Google, Twitter
    // heap search. interesting.
    // a key clue is to start searching from the lowest height, and it can guarantee the one calculation.
    // 40 / 40 test cases passed.
    // 149 ms
    public class Solution {
        public class Cell{
            int row, col, height;
            Cell(int row, int col, int height){
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            if(heightMap == null || heightMap.length <= 1) return 0;
            int row = heightMap.length, col = heightMap[0].length;
            PriorityQueue<Cell> heap = new PriorityQueue<>((a,b) -> a.height - b.height);
            boolean[][] isVisited = new boolean[row][col];

            // add boarders to heap
            // left and right boarder
            for(int i=0; i<row; i++){
                isVisited[i][0] = true;
                isVisited[i][col-1] = true;
                heap.add(new Cell(i, 0, heightMap[i][0]));
                heap.add(new Cell(i, col-1, heightMap[i][col-1]));
            }

            // top and bottom
            for(int i=0; i<col; i++){
                isVisited[0][i] = true;
                isVisited[row-1][i] = true;
                heap.add(new Cell(0, i, heightMap[0][i]));
                heap.add(new Cell(row-1, i,  heightMap[row-1][i]));
            }

            int ret = 0;
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while(!heap.isEmpty()){
                Cell cur = heap.remove();
                for(int[] dir : dirs){
                    int r = cur.row + dir[0], c = cur.col + dir[1];
                    if(r >= 0 && r < row && c >= 0 && c < col && !isVisited[r][c]){
                        isVisited[r][c] = true;
                        ret += Math.max(0, cur.height - heightMap[r][c]);
                        heap.add(new Cell(r, c, Math.max(heightMap[r][c], cur.height)));
                    }
                }
            }
            return ret;
        }
    }
}
