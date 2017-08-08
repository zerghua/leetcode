package leetcode;

/**
 * Created by Hua on 7/10/2017.

 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.

 */

import leetcode.N0_data_strcture.*;
public class N270_ClosestBinarySearchTreeValue {
    // Microsoft, Google.
    // 66 / 66 test cases passed.
    // 1 ms
    public class Solution {
        int ret = 0;
        double distance = Double.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            dfs(root, target);
            return ret;
        }

        public void dfs(TreeNode node, double target){
            if(node == null) return;
            if(Math.abs(node.val - target) < distance){
                distance = Math.abs(node.val - target);
                ret = node.val;
            }
            if(target > node.val) dfs(node.right, target);
            else dfs(node.left, target);
        }
    }
}
