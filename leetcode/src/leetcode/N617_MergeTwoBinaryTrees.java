package leetcode;

/**
 * Created by Hua on 6/23/2017.

 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values
 up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:

 Input:
 Tree 1                     Tree 2
     1                         2
    / \                       / \
   3   2                     1   3
  /                           \   \
 5                             4   7
 Output:
 Merged tree:
     3
    / \
   4   5
  / \   \
 5   4   7

 Note: The merging process must start from the root nodes of both trees.


 */

import leetcode.N0_data_strcture.*;
public class N617_MergeTwoBinaryTrees {
    // tree traversal
    // 183 / 183 test cases passed.
    // 15 ms
    public class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return dfs(t1, t2);
        }

        public TreeNode dfs(TreeNode t1, TreeNode t2){
            if(t1 == null && t2 == null) return null;
            TreeNode root = null;
            if(t1 != null && t2 == null){
                root = new TreeNode(t1.val);
                root.left = dfs(t1.left, null);
                root.right = dfs(t1.right, null);
            }else if(t1 == null && t2 != null){
                root = new TreeNode(t2.val);
                root.left = dfs(null, t2.left);
                root.right = dfs(null, t2.right);
            }else{
                root = new TreeNode(t1.val + t2.val);
                root.left = dfs(t1.left, t2.left);
                root.right = dfs(t1.right, t2.right);
            }
            return root;
        }
    }

    // concise code
    // 183 / 183 test cases passed.
    // 17 ms
    public class Solution2{
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null) return null;

            int val = (t1 == null? 0 : t1.val) + (t2 == null? 0 : t2.val);
            TreeNode root = new TreeNode(val);

            root.left = mergeTrees((t1 == null? null : t1.left), (t2 == null? null : t2.left));
            root.right = mergeTrees((t1 == null? null : t1.right), (t2 == null? null : t2.right));

            return root;
        }
    }
}
