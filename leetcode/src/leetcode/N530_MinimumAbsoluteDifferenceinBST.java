package leetcode;

/**
 * Created by HuaZ on 5/7/2017.

 Given a binary search tree with non-negative values, find the minimum absolute difference
 between values of any two nodes.

 Example:

 Input:

 1
  \
   3
  /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

 Note: There are at least two nodes in this BST.

 */
import leetcode.N0_data_strcture.*;
public class N530_MinimumAbsoluteDifferenceinBST {
    // Google
    // in-order traversal, one trick is to set pre = -1 and avoid the first diff.
    // 186 / 186 test cases passed.
    // 14 ms
    public class Solution {
        int ret = Integer.MAX_VALUE, pre = -1;
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ret;
        }

        public void dfs(TreeNode node){
            if(node == null) return ;
            dfs(node.left);
            if(pre != -1) ret = Math.min(ret, node.val - pre);
            pre = node.val;
            dfs(node.right);
        }
    }
}
