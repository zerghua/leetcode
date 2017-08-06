package leetcode;

/**
 * Created by HuaZ on 8/5/2017.

 Given a Binary Search Tree and a target number, return true if there exist two elements
 in the BST such that their sum is equal to the given target.

 Example 1:

 Input:
      5
     / \
    3   6
   / \   \
 2   4   7

 Target = 9

 Output: True

 Example 2:

 Input:
     5
    / \
   3   6
  / \   \
 2   4   7

 Target = 28

 Output: False


 */
import leetcode.N0_data_strcture.*;

import java.util.*;

public class N653_TwoSumIV_InputisaBST {
    // leetcode contest 44, passed solution
    public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            return dfs(root, k, new HashSet());
        }

        public boolean dfs(TreeNode node, int k, HashSet<Integer> set){
            if(node == null) return false;
            if(set.contains(k - node.val)) return true;
            set.add(node.val);
            if(dfs(node.left, k, set) || dfs(node.right, k, set)) return true;
            return false;
        }
    }
}
