package leetcode;
import leetcode.N0_data_strcture.*;
/*

 Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */


public class N100_isSameTree {
    // Bloomberg
    // 284ms, 54%
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null) return true;
        else if(p==null || q == null) return false;
        else if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}
