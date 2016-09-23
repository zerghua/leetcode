package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/17/2016.

 For a undirected graph with tree characteristics,
 we can choose any node as the root. The result graph is then a rooted tree.
 Among all possible rooted trees, those with minimum height are called
 minimum height trees (MHTs). Given such a graph, write a function to find
 all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1.
 You will be given the number n anda list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0]
 and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

   0
   |
   1
  / \
 2   3

 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
   3
   |
   4
   |
   5

 return [3, 4]

 Hint:

 How many MHTs can a graph have at most?

 Note:

 (1) According to the definition of tree on Wikipedia:
 “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 In other words, any connected graph without simple cycles is a tree.”

 (2) The height of a rooted tree is the number of edges on the longest downward path
 between the root and a leaf.


 */
public class N310_MinimumHeightTrees {
    // 45 ms
    // BFS, remove all leaf node until remain node <=2 and return.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if(n<=1) {
            ret.add(0);
            return ret;
        }

        int[] neighbor = new int[n];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i, new ArrayList<>());
        for(int[] edge: edges){
            neighbor[edge[0]]++;
            neighbor[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //add all leaf node
        for(int i=0;i<n;i++) {
            if(neighbor[i] == 1) ret.add(i);
        }

        while(n>2){
            ArrayList<Integer> new_leafs= new ArrayList<>();
            for(int leaf_node: ret){
                n--;
                for(int neighbor_node: graph.get(leaf_node)){
                    neighbor[neighbor_node]--;
                    if(neighbor[neighbor_node] == 1) new_leafs.add(neighbor_node);
                }
            }
            ret = new_leafs;
        }
        return ret;
    }
}
