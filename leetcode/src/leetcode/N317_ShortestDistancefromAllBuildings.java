package leetcode;

/**
 * Created by Hua on 7/27/2017.

 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.

 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 So return 7.

 Note:
 There will be at least one building.
 If it is not possible to build such house according to the above rules, return -1.


 */

import java.util.*;
public class N317_ShortestDistancefromAllBuildings {
    // google (Premium)
    // BFS with extra tricks
    // 72 / 72 test cases passed.
    // 61 ms
    public class Solution {
        public int shortestDistance(int[][] grid) {
            int row = grid.length, col = (row == 0) ? 0 : grid[0].length;
            int[][] dist = new int[row][col];       // total distance to reach all buildings from this point
            int[][] buildings = new int[row][col];  // how many building can be reached from this point
            int numOfBuildings = 0;
            for(int i=0; i< row; i++){
                for(int j=0; j<col; j++){
                    if(grid[i][j] == 1) {
                        numOfBuildings++;  // count total number of buildings
                        bfs(i, j, dist, buildings, grid);
                    }
                }
            }

            int ret = Integer.MAX_VALUE;
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(buildings[i][j] == numOfBuildings) ret = Math.min(ret, dist[i][j]);
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }

        public void bfs(int i, int j, int[][] dist, int[][] buildings, int[][] grid){
            int row = grid.length, col = (row == 0) ? 0 : grid[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            boolean[][] isVisited = new boolean[row][col];
            LinkedList<int[]> list = new LinkedList();
            list.add(new int[]{i, j});
            int level = 1;
            isVisited[i][j] = true;
            while(!list.isEmpty()){
                int size = list.size();
                for(int k=0; k<size; k++){
                    int[] node = list.removeFirst();

                    for(int[] dir : dirs){
                        int x = node[0] + dir[0], y = node[1] + dir[1];
                        if(x >=0 && x < row && y>=0 && y< col && !isVisited[x][y] && grid[x][y] == 0){
                            dist[x][y] += level;
                            buildings[x][y]++;
                            isVisited[x][y] = true;
                            list.add(new int[]{x,y});
                        }
                    }
                }
                level++;
            }

        }
    }
}
