package leetcode;

/**
 * Created by Hua on 7/17/2017.

 Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,

     5
    / \
   1   5
  / \   \
 5   5   5

 return 4.

 */

import leetcode.N0_data_strcture.*;
public class N250_CountUnivalueSubtrees {
    // no company (Premium)
    // 197 / 197 test cases passed.
    // 1 ms
    // post order traversal
    public class Solution {
        int ret = 0;
        public int countUnivalSubtrees(TreeNode root) {
            dfs(root);
            return ret;
        }

        public boolean dfs(TreeNode node){
            if(node == null) return true;

            boolean isLeftUnival = dfs(node.left);
            boolean isRightUnival = dfs(node.right);
            if(isLeftUnival && isRightUnival && (node.left == null || node.left.val == node.val)
                    && (node.right == null || node.right.val == node.val)){
                ret++;
                return true;
            }

            return false;
        }
    }
}
