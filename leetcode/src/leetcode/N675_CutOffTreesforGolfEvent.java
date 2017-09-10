package leetcode;

/**
 * Created by HuaZ on 9/10/2017.

 You are asked to cut off trees in a forest for a golf event.
 The forest is represented as a non-negative 2D map, in this map:

 0 represents the obstacle can't be reached.
 1 represents the ground can be walked through.
 The place with number bigger than 1 represents a tree can be walked through,
 and this positive number represents the tree's height.

 You are asked to cut off all the trees in this forest in the order of tree's height -
 always cut off the tree with lowest height first. And after cutting,
 the original place has the tree will become a grass (value 1).

 You will start from the point (0, 0) and you should output the minimum steps you need to walk
 to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

 You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

 Example 1:

 Input:
 [
 [1,2,3],
 [0,0,4],
 [7,6,5]
 ]
 Output: 6

 Example 2:

 Input:
 [
 [1,2,3],
 [0,0,0],
 [7,6,5]
 ]
 Output: -1

 Example 3:

 Input:
 [
 [2,3,4],
 [0,0,5],
 [8,7,6]
 ]
 Output: 6
 Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

 Hint: size of the given matrix will not exceed 50x50.


 */

import java.util.*;
public class N675_CutOffTreesforGolfEvent {
    // BFS between two points loop over a set of lists + heap(sort on height)
    // my solution
    // 53 / 53 test cases passed.
    // 469 ms
    class Solution {
        int[][] dirs = {{0,1}, {0,-1}, {1,0},{-1,0}};

        public int cutOffTree(List<List<Integer>> forest) {
            if(forest == null || forest.size() == 0) return 0;
            int m = forest.size(), n = forest.get(0).size();

            // add tree into heap sorted by height, a[0] height, a[1] x, a[2] y
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
            for(int i = 0; i<forest.size(); i++){
                for(int j = 0; j< forest.get(i).size(); j++){
                    int height = forest.get(i).get(j);
                    if(height > 1) heap.add(new int[]{height, i, j});
                }
            }

            // BFS on each smallest tree
            int start_x = 0, start_y = 0, ret= 0;
            while(!heap.isEmpty()){
                int[] next = heap.remove();
                int steps = bfs(start_x, start_y, next[1], next[2], forest,m,n);
                if(steps == -1) return -1;
                ret += steps;
                start_x = next[1];
                start_y = next[2];
            }
            return ret;
        }

        private int bfs(int start_x, int start_y, int end_x, int end_y, List<List<Integer>> forest, int m, int n){
            if(start_x == end_x && start_y == end_y) return 0;
            boolean[][] isVisited = new boolean[m][n]; // implicit m*n matrix
            isVisited[start_x][start_y] = true;
            int ret = 0;
            LinkedList<int[]> list = new LinkedList();
            list.add(new int[]{start_x, start_y});
            while(!list.isEmpty()){
                int size = list.size();
                ret++;
                for(int i=0; i<size; i++) {
                    int[] cur = list.removeFirst();

                    // add neighbours
                    for (int[] dir : dirs) {
                        int next_x = cur[0] + dir[0], next_y = cur[1] + dir[1];

                        // inner return is faster than check return in next loop
                        // my outer check will TLE.
                        if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
                                && forest.get(next_x).get(next_y) != 0 && !isVisited[next_x][next_y]){
                            if (next_x == end_x && next_y == end_y) return ret;
                            list.add(new int[]{next_x, next_y});
                            isVisited[next_x][next_y] = true;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
