package leetcode;

/**
 * Created by Hua on 5/18/2017.

 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
 a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 also be considered as a subtree of itself.

 Example 1:
 Given tree s:

     3
    / \
   4   5
  / \
 1   2

 Given tree t:

   4
  / \
 1   2

 Return true, because t has the same structure and node values with a subtree of s.

 Example 2:
 Given tree s:

       3
      / \
     4   5
    / \
   1   2
  /
 0

 Given tree t:

   4
  / \
 1   2

 Return false.


 */

import leetcode.N0_data_strcture.*;
public class N572_SubtreeofAnotherTree {
    // Facebook, Ebay
    // tree recursion
    // 176 / 176 test cases passed.
    // 27 ms
    public class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null) return false;
            return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean dfs(TreeNode s, TreeNode t){
            if(s == null && t == null) return true;
            if(s == null || t == null) return false;
            return s.val == t.val && dfs(s.left, t.left) && dfs(s.right, t.right);
        }
    }
}
