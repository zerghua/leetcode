package leetcode;

/**
 * Created by Hua on 7/19/2017.

 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.



 */

import java.util.*;
public class N261_GraphValidTree {
    // Google, Facebook
    // graph, check if graph is tree.
    // a valid tree means: all nodes are connected and there is not circle.
    // DFS visit all nodes, return false if find circle.
    // 44 / 44 test cases passed.
    // 15 ms
    public class Solution {
        public boolean validTree(int n, int[][] edges) {
            if(n == 0 || n == 1) return true;
            if(n < 0 || edges == null || edges.length == 0 ) return false;
            HashMap<Integer, List<Integer>> map = new HashMap();
            for(int[] e : edges){
                if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
                map.get(e[0]).add(e[1]);

                if(!map.containsKey(e[1])) map.put(e[1], new ArrayList());
                map.get(e[1]).add(e[0]);
            }

            boolean[] isVisited = new boolean[n];
            boolean findCycle = findCycle(map, isVisited, edges[0][0], edges[0][0]);

            for(int i=0; i<n; i++){
                if(!isVisited[i]) return false;
            }

            return !findCycle;
        }

        public boolean findCycle(HashMap<Integer, List<Integer>> map, boolean[] isVisited, int e, int parent){
            if(isVisited[e]) return true;

            isVisited[e] = true;
            if(map.containsKey(e)){
                for(int adj : map.get(e)){
                    if(adj == parent) continue;
                    if(findCycle(map, isVisited, adj, e)) return true;
                }
            }
            return false;
        }
    }


    // maybe a better solution, union find and if it's a valid tree it must has n -1 edges!
    // 44 / 44 test cases passed.
    // 1 ms
    public class Solution2 {
        public boolean validTree(int n, int[][] edges) {
            // initialize n isolated islands
            int[] nums = new int[n];
            Arrays.fill(nums, -1);

            // perform union find
            for (int i = 0; i < edges.length; i++) {
                int x = find(nums, edges[i][0]);
                int y = find(nums, edges[i][1]);

                // if two vertices happen to be in the same set
                // then there's a cycle
                if (x == y) return false;

                // union
                nums[x] = y;
            }

            return edges.length == n - 1;  // very important property of a valid tree.
        }

        int find(int nums[], int i) {
            if (nums[i] == -1) return i;
            return find(nums, nums[i]);
        }
    }

}
