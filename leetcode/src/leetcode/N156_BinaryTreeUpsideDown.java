package leetcode;

/**
 * Created by HuaZ on 10/22/2016.

 linkedin phone interview questions


 Given a binary tree where all the right nodes are leaf nodes,
 flip it upside down and turn it into a tree with left leaf nodes.

 Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.

 /* for example, turn these:
 *
 *        1                 1
 *       / \               / \
 *      2   3             2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3           2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *       6                    2
 *      / \                 / \
 *     7   4               3   1
 *        / \
 *       5   2
 *          / \
 *         3   1

 http://buttercola.blogspot.com/2015/10/leetcode-binary-tree-upside-down.html
 */

import leetcode.N0_data_strcture.*;
public class N156_BinaryTreeUpsideDown {
    // bottom-up approach, left-most node will be root, so recurse to it and return it.
    // 144 / 144 test cases passed.
    // 1 ms
    public class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            return dfs(root, null);
        }

        public TreeNode dfs(TreeNode node, TreeNode parent){
            if(node == null) return parent; // return left-most node
            TreeNode root = dfs(node.left, node);
            node.left = (parent == null)? null: parent.right;
            node.right = parent;
            return root;
        }
    }
}
