package leetcode;

/**
 * Created by HuaZ on 7/15/2017.

 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to find the number of connected components in an undirected graph.

 Example 1:

 0          3
 |          |
 1 --- 2    4

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:

 0           4
 |           |
 1 --- 2 --- 3

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0] and
 thus will not appear together in edges.

 */

import java.util.*;
public class N323_NumberofConnectedComponentsinanUndirectedGraph {
    // Google, Twitter
    // this is a classic union find problem, check out algorithms 1 from Princeton U.
    // but here I use a general DFS to solve it.
    // 45 / 45 test cases passed.
    // 24 ms
    public class Solution {
        public int countComponents(int n, int[][] edges) {
            // parse input as directed graph stored in hashmap list
            HashMap<Integer, List<Integer>> map = new HashMap();
            for(int[] e: edges){
                if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
                if(!map.containsKey(e[1])) map.put(e[1], new ArrayList());
                map.get(e[0]).add(e[1]);
                map.get(e[1]).add(e[0]);
            }

            HashSet<Integer> set = new HashSet();
            int ret = 0;
            for(int i=0; i<n; i++){
                if(!set.contains(i)){
                    dfs(set, i, map);
                    ret++;
                }
            }
            return ret;
        }

        public void dfs(HashSet<Integer> set, int num, HashMap<Integer, List<Integer>> map){
            if(set.contains(num)) return;
            set.add(num);
            if(map.containsKey(num)){
                for(int e : map.get(num)) dfs(set, e, map);
            }
        }
    }
}
