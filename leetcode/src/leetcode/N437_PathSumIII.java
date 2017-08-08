package leetcode;

/**
 * Created by HuaZ on 10/23/2016.

 You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards
 (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

        10
       /  \
      5   -3
     / \    \
   3   2    11
  / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11


 */
import leetcode.N0_data_strcture.*;
public class N437_PathSumIII {
    // no company
    // time o(n^2) worse case like linked list, o(nlogn) if balanced tree.
    // 30 ms 126 / 126 test cases passed.
    // similar to Path Sum I, which is only from root-leaf
    // this one can start from any node, meaning with extra dfs on root's left and right.
    public class Solution {
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return 0;
            return dfs(root, sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
        }
        public int dfs(TreeNode node, int sum){
            if(node == null) return 0;
            return (node.val == sum ? 1 : 0) + dfs(node.left, sum-node.val) + dfs(node.right, sum-node.val);
        }
    }

}
