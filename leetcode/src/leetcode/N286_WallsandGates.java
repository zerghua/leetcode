package leetcode;

/**
 * Created by HuaZ on 7/16/2017.

 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent
 INF as you may assume that the distance to a gate is less than 2147483647.

 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF

 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4


 */
import java.util.*;
public class N286_WallsandGates {
    // Google, Facebook
    // BFS
    // 62 / 62 test cases passed.
    // 18 ms
    public class Solution {
        public void wallsAndGates(int[][] rooms) {
            if(rooms == null || rooms.length == 0) return ;
            // add gate(0) to list
            LinkedList<int[]> list = new LinkedList();
            int m = rooms.length, n = rooms[0].length;
            for(int i = 0; i<m ; i++){
                for(int j = 0; j<n; j++){
                    if(rooms[i][j] == 0) list.add(new int[]{i, j});
                }
            }

            int[][] dirs = {{0, 1}, {0, -1}, {1 ,0}, {-1, 0}};
            while(!list.isEmpty()){
                int[] node = list.removeFirst();
                int i = node[0], j = node[1];
                for(int[] dir : dirs){
                    int new_i = i + dir[0], new_j = j + dir[1];
                    if(new_i <0 || new_i >= m || new_j <0 || new_j >=n || rooms[new_i][new_j] == -1
                            || rooms[new_i][new_j] != Integer.MAX_VALUE) continue;
                    rooms[new_i][new_j] = rooms[i][j] + 1;
                    list.add(new int[]{new_i, new_j});
                }
            }

        }
    }
}
