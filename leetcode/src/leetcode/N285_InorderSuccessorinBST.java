package leetcode;

/**
 * Created by Hua on 7/20/2017.

 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.


 Test cases:

 Input:[6,2,8,0,4,7,9,null,null,3,5]
 node with value 2
 Expected:3


 Input:[2,null,3]
 node with value 2
 Expected:3


 */

import leetcode.N0_data_strcture.*;
public class N285_InorderSuccessorinBST {
    // Microsoft, Facebook (Premium)
    // concise code
    // 29 / 29 test cases passed.
    // 4 ms
    public class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode candidate = null;
            while(root != null){
                if(root.val > p.val){
                    candidate = root;
                    root = root.left;
                }else root = root.right;
            }
            return candidate;
        }
    }


    // 29 / 29 test cases passed.
    // 4 ms
    public class Solution2 {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode candidate = null;
            while(root != p){
                if(root.val > p.val){
                    candidate = root;
                    root = root.left;
                }else root = root.right;
            }

            if(root.right == null) return candidate;
            else{
                TreeNode ret = root.right;
                while(ret.left != null) ret = ret.left;
                return ret;
            }
        }
    }





    // recursive successor
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    //recursive Predecessor
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }


}
