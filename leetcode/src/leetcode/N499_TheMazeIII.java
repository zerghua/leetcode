package leetcode;

import java.util.LinkedList;

/**
 * Created by HuaZ on 7/29/2017.

 There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces
 by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall.
 When the ball stops, it could choose the next direction. There is also a hole in this maze.
 The ball will drop into the hole if it rolls on to the hole.

 Given the ball position, the hole position and the maze, find out how the ball could drop into
 the hole by moving the shortest distance. The distance is defined by the number of empty spaces
 traveled by the ball from the start position (excluded) to the hole (included). Output the moving
 directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways,
 you should output the lexicographically smallest way. If the ball cannot reach the hole,
 output "impossible".

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 You may assume that the borders of the maze are all walls. The ball and the hole coordinates
 are represented by row and column indexes.

 Example 1

 Input 1: a maze represented by a 2D array

 0 0 0 0 0
 1 1 0 0 1
 0 0 0 0 0
 0 1 0 0 1
 0 1 0 0 0

 Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 Input 3: hole coordinate (rowHole, colHole) = (0, 1)

 Output: "lul"
 Explanation: There are two shortest ways for the ball to drop into the hole.
 The first way is left -> up -> left, represented by "lul".
 The second way is up -> left, represented by 'ul'.
 Both ways have shortest distance 6, but the first way is lexicographically smaller
 because 'l' < 'u'. So the output is "lul".

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 0 0 0
 1 1 0 0 1
 0 0 0 0 0
 0 1 0 0 1
 0 1 0 0 0

 Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 Input 3: hole coordinate (rowHole, colHole) = (3, 0)
 Output: "impossible"
 Explanation: The ball cannot reach the hole.

 Note:

 There is only one ball and one hole in the maze.
 Both the ball and hole exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures),
 but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.



 */
public class N499_TheMazeIII {
    // google (Premium)
    // advanced BFS with custom class and sequence of next visit is important
    // non-trivia BFS code
    // 64 / 64 test cases passed.
    // 13 ms
    public class Solution {
        public class Node{
            int row, col, direction;
            String str;
            Node(int row, int col, int direction, String str){
                this.row = row;
                this.col = col;
                this.direction = direction;
                this.str = str;
            }
        }

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            String[] directions = {"d", "l", "r", "u"}; // sequence is important for lexicographically order
            int[][] dirs = {{1,0}, {0,-1}, {0,1},{-1,0}};
            int m = maze.length, n = maze[0].length;
            boolean[][][] isVisited = new boolean[m][n][4];
            LinkedList<Node> list = new LinkedList();
            // init point with 4 directions
            for(int i=0; i<4;i++){
                int nextRow = ball[0] + dirs[i][0], nextCol = ball[1] + dirs[i][1];
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                    && maze[nextRow][nextCol] == 0) {
                    list.add(new Node(ball[0], ball[1], i, directions[i]));
                }
            }

            while(!list.isEmpty()){
                Node node = list.removeFirst();
                if(hole[0] == node.row && hole[1] == node.col) return node.str;

                isVisited[node.row][node.col][node.direction] = true;
                // go with the same direction
                int nextRow = node.row + dirs[node.direction][0];
                int nextCol = node.col + dirs[node.direction][1];

                // not hit wall, continue roll
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                        && maze[nextRow][nextCol] == 0){
                    if(!isVisited[nextRow][nextCol][node.direction])
                        list.add(new Node(nextRow, nextCol, node.direction, node.str));
                }else{ // hit wall
                    // visit all four directions
                    for(int i=0 ; i<4 ; i++){
                        if(i != node.direction){
                            nextRow = node.row + dirs[i][0];
                            nextCol = node.col + dirs[i][1];

                            if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                                    && maze[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol][i]){
                                list.add(new Node(nextRow, nextCol, i, node.str + directions[i]));
                            }
                        }
                    }
                }
            }
            return "impossible";
        }
    }
}
