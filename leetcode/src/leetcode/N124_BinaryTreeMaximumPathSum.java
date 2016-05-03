package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 5/3/2016.
 *
 *  Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from
 some starting node to any node in the tree along the parent-child connections.
 The path does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3

 Return 6.
 */


public class N124_BinaryTreeMaximumPathSum {
    int global_max =Integer.MIN_VALUE;

    // 2ms
    // bottom up
    public int maxPathSum(TreeNode root) {
        helper(root);
        return global_max;
    }

    public int helper(TreeNode node){
        if(node == null) return 0;

        int left_max = helper(node.left);
        int right_max = helper(node.right);

        // return partial max
        int partial_max = Math.max(node.val, Math.max(node.val+left_max, node.val+right_max));

        //update global max
        global_max = Math.max(global_max, Math.max(node.val + left_max + right_max, partial_max));

        return partial_max;
    }

}
