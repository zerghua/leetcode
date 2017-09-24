package leetcode;

/**
 * Created by HuaZ on 9/24/2017.

 We are given a "tree" in the form of a 2D-array, with distinct values for each node.

 In the given 2D-array, each element pair [u, v] represents that v is a child of u in the tree.

 We can remove exactly one redundant pair in this "tree" to make the result a tree.

 You need to find and output such a pair. If there are multiple answers for this question,
 output the one appearing last in the 2D-array. There is always at least one answer.

 Example 1:

 Input: [[1,2], [1,3], [2,3]]
 Output: [2,3]
 Explanation: Original tree will be like this:
   1
  / \
 2 - 3

 Example 2:

 Input: [[1,2], [1,3], [3,1]]
 Output: [3,1]
 Explanation: Original tree will be like this:
   1
  / \\
 2   3

 Note:
 The size of the input 2D-array will be between 1 and 1000.
 Every integer represented in the 2D-array will be between 1 and 2000.

 */
public class N684_RedundantConnection {
    // union find to detect first cyclic edge
    // 38 / 38 test cases passed.
    // 7 ms
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] a = new int[2001];
            for(int i=0; i<2001; i++) a[i] = i;
            for(int[] e : edges){
                int parent = e[0], child = e[1];
                int parent_root = find(parent, a), child_root = find(child, a);
                if(parent_root == child_root) return e;
                a[child_root] = parent_root;
            }
            return null;
        }

        // recursively search root of i
        public int find(int i, int[] a){
            while(i != a[i]){
                i = find(a[i], a);
            }
            return i;
        }
    }
}
