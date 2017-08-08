package leetcode;

/**
 * Created by HuaZ on 5/6/2017.

 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
 BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
    5
  /   \
 2     13

 Output: The root of a Greater Tree like this:
     18
   /   \
 20     13


 */

import leetcode.N0_data_strcture.*;
public class N538_ConvertBSTtoGreaterTree {
    // Amazon
    // interesting, reverse order in-order traversal
    // 212 / 212 test cases passed.
    // 16 ms
    public class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            dfs(root);
            return root;
        }

        public void dfs(TreeNode node){
            if(node == null) return;
            dfs(node.right);
            sum += node.val;
            node.val = sum;
            dfs(node.left);
        }
    }
}
