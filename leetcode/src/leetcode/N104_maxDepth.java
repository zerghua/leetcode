package leetcode;
import leetcode.N0_data_strcture.*;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 */


public class N104_maxDepth {
    // Apple, Uber
    // 316 ms  87%
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
