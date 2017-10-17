package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/15/2017.

 Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 connected 4-directionally (horizontal or vertical.)
 You may assume all four edges of the grid are surrounded by water.

 Count the number of distinct islands. An island is considered to be the same as another
 if and only if one island can be translated (and not rotated or reflected) to equal the other.

 Example 1:

 11000
 11000
 00011
 00011

 Given the above grid map, return 1.

 Example 2:

 11011
 10000
 00001
 11011

 Given the above grid map, return 3.

 Notice that:

 11
 1

 and

 1
 11

 are considered different island shapes, because we do not consider reflection / rotation.

 Note: The length of each dimension in the given grid does not exceed 50.

 */
public class N694_NumberofDistinctIslands {
    // my passed contest solution
    class Solution {
        class Node{
            int x, y;
            Node(int i, int j){
                x=i; y = j;
            }
        }

        public int numDistinctIslands(int[][] grid) {
            HashSet<String> set = new HashSet();
            int m=grid.length, n = grid[0].length;
            boolean[][] isVisited = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n;j++){
                    LinkedList<Node> list = new LinkedList();
                    dfs(grid, isVisited, i, j, list);
                    if(!list.isEmpty()){
                        String s = normalize(list);
                        set.add(s);
                    }
                }
            }
            return set.size();
        }
        public void dfs(int[][] grid, boolean[][] isVisited, int i, int j, List<Node> list){
            int m=grid.length, n = grid[0].length;
            if(i <0 || i>= m || j<0 || j>=n) return;
            if(isVisited[i][j] || grid[i][j] == 0) return;
            isVisited[i][j] = true;
            list.add(new Node(i,j));

            dfs(grid,isVisited, i+1,j, list);
            dfs(grid,isVisited, i-1,j, list);
            dfs(grid,isVisited, i,j+1, list);
            dfs(grid,isVisited, i,j-1, list);
        }

        public String normalize(LinkedList<Node> list){
            Collections.sort(list, (a,b) -> a.x != b.x ? a.x - b.x : a.y - b.y); // sort x then y
            int min_x = list.getFirst().x, min_y = list.getFirst().y;
            for(Node n : list) min_y = Math.min(min_y, n.y);  // find min_y
            StringBuilder s = new StringBuilder();
            for(Node n : list){
                s.append(n.x - min_x).append(":").append(n.y-min_y).append(";");
            }
            return s.toString();
        }
    }



    // others solution
    // When we start a depth-first search on the top-left square of some island,
    // the path taken by our depth-first search will be the same if and only if the shape is the same.
    // We can exploit this by recording the path we take as our shape -
    // keeping in mind to record both when we enter and when we exit the function.
    class Solution2 {
        int[][] grid;
        boolean[][] seen;
        ArrayList<Integer> shape;

        public void explore(int r, int c, int di) {
            if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                    grid[r][c] == 1 && !seen[r][c]) {
                seen[r][c] = true;
                shape.add(di);
                explore(r+1, c, 1);
                explore(r-1, c, 2);
                explore(r, c+1, 3);
                explore(r, c-1, 4);
                shape.add(0);
            }
        }
        public int numDistinctIslands(int[][] grid) {
            this.grid = grid;
            seen = new boolean[grid.length][grid[0].length];
            Set shapes = new HashSet<ArrayList<Integer>>();

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    shape = new ArrayList<Integer>();
                    explore(r, c, 0);
                    if (!shape.isEmpty()) {
                        shapes.add(shape);
                    }
                }
            }

            return shapes.size();
        }
    }
}
