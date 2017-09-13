package leetcode;

/**
 * Created by HuaZ on 7/22/2017.

 Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:

     10
    / \
   5  15
  / \   \
 1   8   7

 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.

 Follow up:
 Can you figure out ways to solve it with O(n) time complexity?

 */
import leetcode.N0_data_strcture.*;
public class N333_LargestBSTSubtree {
    // Microsoft (Premium)
    // bottom up solution o(n)
    // 73 / 73 test cases passed.
    // 6 ms
    public class Solution {
        int max = 0;
        public int largestBSTSubtree(TreeNode root) {
            dfs(root);
            return max;
        }

        // ret[] = {min_value, max_value, count, isBST}
        public int[] dfs(TreeNode node){
            if(node == null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE, 0, 1};
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            if(left[3] == 0 || right[3] == 0) return new int[]{0,0,0,0};

            if(node.val > left[1] && node.val < right[0]){
                max = Math.max(max, 1 + left[2] + right[2]);
                return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), 1 + left[2] + right[2], 1};
            }

            return new int[]{0,0,0,0};
        }
    }
}
