package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 10/7/2017.
 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 287 / 2932	zerghua	   15	     0:51:35	0:11:58 	0:25:52 	0:51:35



 */
public class Contest_53 {
    // bits
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int last = n & 1;
            n >>>= 1;
            while(n != 0){
                int cur = (n & 1);
                if((cur ^ last) != 1) return false;
                n >>>= 1;
                last = cur;
            }
            return true;
        }
    }

    // BFS?
    class Solution2 {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            int m=grid.length, n = grid[0].length;
            boolean[][] isVisited = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n;j++){
                    max = Math.max(max, dfs(grid, isVisited, i, j));
                }
            }
            return max;
        }

        public int dfs(int[][] grid, boolean[][] isVisited, int i, int j){
            int m=grid.length, n = grid[0].length;
            if(i <0 || i>= m || j<0 || j>=n) return 0;
            if(isVisited[i][j] || grid[i][j] == 0) return 0;
            isVisited[i][j] = true;

            return 1 + dfs(grid,isVisited, i+1,j) + dfs(grid,isVisited, i-1,j) +
                    dfs(grid,isVisited, i,j+1) + dfs(grid,isVisited, i,j-1);
        }
    }


    class Solution3 {
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


    // backtracking with pruning?
    // TLE
    class Solution4 {
        int ret = Integer.MAX_VALUE;
        public int minStickers(String[] stickers, String target) {
            if(!hasAllChar(stickers, target)) return -1;  //pruning
            int[] t = new int[26];
            for(char c : target.toCharArray()) t[c - 'a']++;

            LinkedList<int[]> list = new LinkedList(); // shorter list candidate, pruning
            for(String s : stickers){
                for(char c : s.toCharArray()) {
                    if(t[c - 'a'] != 0){
                        int[] arr = new int[26];
                        for(char x : s.toCharArray()) arr[x - 'a']++;
                        list.add(arr);
                        break;
                    }
                }
            }

            dfs(list, t, 0, 0);
            return ret;
        }

        public void dfs(LinkedList<int[]> list, int[] t, int start, int count){
            boolean isOK = true;
            for(int x : t) {
                //System.out.println("x="+x);
                if(x > 0) {
                    isOK = false;
                    break;
                }
            }
            if(isOK) {  // means find all
                //System.out.println("count="+count + " start="+start);
                ret = Math.min(ret, count);
                return;
            }

            for(int i=start; i<list.size(); i++){
                int[] s = list.get(i);
                boolean[] isUsed = new boolean[26];
                boolean isAnyUsed = false;

                // set t
                for(int j=0; j<26;j++){
                    if(t[j] >0 && s[j] > 0){
                        t[j] -= s[j];
                        isUsed[j] = true;
                        isAnyUsed = true;
                    }
                }

                if(isAnyUsed) dfs(list, t, i, count+1);
                else dfs(list, t, i+1, count);

                // ret t
                if(!isAnyUsed) continue;
                for(int j=0; j<26;j++){
                    if(isUsed[j]) t[j] += s[j];
                }
            }
        }

        public boolean hasAllChar(String[] stickers, String target){
            boolean[] b = new boolean[26];
            for(char c : target.toCharArray()) b[c - 'a'] = true;
            for(String s : stickers){
                for(char c : s.toCharArray()) b[c - 'a'] = false;
            }
            for(boolean x : b) if(x) return false;
            return true;
        }
    }
}
