package leetcode;

/**
 * Created by HuaZ on 7/16/2017.

 There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces
 by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
 When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, determine whether the ball
 could stop at the destination.

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

 Output: true
 Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 Output: false
 Explanation: There is no way for the ball to stop at the destination.

 Note:

 There is only one ball and one destination in the maze.
 Both the ball and the destination exist on an empty space, and they will not be
 at the same positioninitially.
 The given maze does not contain border (like the red rectangle in the example pictures),
 but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.


 */
import java.util.*;
public class N490_TheMaze {
    // Google (Premium)
    // BFS with a while condition to travel all the way until stop
    // 78 / 78 test cases passed.
    // 43 ms
    public class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            LinkedList<int[]> list = new LinkedList();
            list.add(start);
            int m = maze.length, n = maze[0].length;
            boolean[][] isVisited = new boolean[m][n];
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            while(!list.isEmpty()){
                int[] node = list.removeFirst();
                int i = node[0], j = node[1];
                isVisited[i][j] = true;
                if(i == destination[0] && j == destination[1]) return true;

                // visited four directions
                for(int[] dir : dirs){
                    // new conditions specific for this problem, continue rolling until stops
                    int new_i = i + dir[0], new_j = j + dir[1]; //might already hit wall
                    while(new_i >=0 && new_i < m && new_j >=0 && new_j <n && maze[new_i][new_j] != 1){
                        new_i += dir[0];
                        new_j += dir[1];
                    }
                    new_i -= dir[0]; new_j -= dir[1]; // step back 1 step because hit wall

                    if(!isVisited[new_i][new_j]) list.add(new int[]{new_i, new_j});
                }
            }
            return false;
        }
    }
}
