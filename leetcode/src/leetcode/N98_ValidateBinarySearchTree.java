package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 4/14/2016.

 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 Example 1:

   2
  / \
 1   3

 Binary tree [2,1,3], return true.

 Example 2:

   1
  / \
 2   3

 Binary tree [1,2,3], return false.

 */
public class N98_ValidateBinarySearchTree {
    // Amazon, Facebook, Microsoft
    //1 ms
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode node, double min, double max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;

        if(isValidBST(node.left, min, node.val) == false) return false;
        if(isValidBST(node.right, node.val, max) == false) return false;

        return true;
    }


    public boolean isValidBST2(TreeNode node, double min, double max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return isValidBST2(node.left, min, node.val) && isValidBST2(node.right, node.val, max);
    }

    // clean solution added on 10/8/2016
    // use null to represent infinity
    // 1 ms  74 / 74 test cases passed.
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }
        public boolean isValid(TreeNode node, Integer low, Integer high){
            if(node == null) return true;
            return (low == null || low < node.val) && (high == null || node.val < high) &&
                    isValid(node.left, low, node.val) && isValid(node.right, node.val, high);
        }
    }

    // added on 10/8/2016
    // inorder traversal, verify if it's monotonic increasing order(look at how to code this way)
    // 1 ms  74 / 74 test cases passed.
    public class Solution2 {
        TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            prev = null;
            return isMonotonicIncreasing(root);
        }
        public boolean isMonotonicIncreasing(TreeNode node){
            if(node == null) return true;
            if(isMonotonicIncreasing(node.left)){
                if(prev != null && prev.val >= node.val) return false;
                prev = node;
                return isMonotonicIncreasing(node.right);
            }
            return false;
        }
    }

}
