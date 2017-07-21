package leetcode;

/**
 * Created by Hua on 7/20/2017.

 There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces
 by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
 When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, find the shortest distance for the ball to
 stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the
 start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 You may assume that the borders of the maze are all walls. The start and destination coordinates
 are represented by row and column indexes.

 Example 1

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (4, 4)

 Output: 12
 Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 Output: -1
 Explanation: There is no way for the ball to stop at the destination.

 Note:

 There is only one ball and one destination in the maze.
 Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures),
 but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 */

import java.util.*;
public class N505_TheMazeII {
    // BFS + heap, modified from N490 The Maze
    // 78 / 78 test cases passed.
    // 110 ms
    public class Solution {
        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            PriorityQueue<int[]> list = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
            list.add(new int[]{start[0], start[1], 0});
            int m = maze.length, n = maze[0].length;
            boolean[][] isVisited = new boolean[m][n];
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            int ret = Integer.MAX_VALUE;

            while(!list.isEmpty()){
                int[] node = list.poll();
                int i = node[0], j = node[1], step = node[2];
                isVisited[i][j] = true;
                if(i == destination[0] && j == destination[1]) ret = Math.min(ret, step);

                // visited four directions
                for(int[] dir : dirs){
                    // new conditions specific for this problem, continue rolling until stops
                    int new_i = i + dir[0], new_j = j + dir[1], new_step = step + 1; //might already hit wall
                    while(new_i >=0 && new_i < m && new_j >=0 && new_j <n && maze[new_i][new_j] == 0){
                        new_i += dir[0];
                        new_j += dir[1];
                        new_step++;
                    }
                    new_i -= dir[0]; new_j -= dir[1]; // step back 1 step because hit wall

                    if(!isVisited[new_i][new_j]) {
                        list.add(new int[]{new_i, new_j, new_step-1});
                    }
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }


    // better BFS, with extra space m*n
    // 78 / 78 test cases passed.
    // 25 ms
    public class Solution2 {
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            int[][] distance = new int[maze.length][maze[0].length];
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
            Queue < int[] > queue = new LinkedList < > ();
            queue.add(start);
            while (!queue.isEmpty()) {
                int[] s = queue.remove();
                for (int[] dir: dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    int count = 0;
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                        distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                        queue.add(new int[] {x - dir[0], y - dir[1]});
                    }
                }
            }
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }
    }

}
