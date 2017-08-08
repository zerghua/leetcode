package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.*;

/**
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 �� k �� BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and
 you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?
 */
public class N230_KthSmallestElementinaBST {
    // Google, Bloomger, Uber
    //use inorder traversal, 2 ms, 23%
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        int count=0, ret=0;
        TreeNode p = root;
        while(!s.empty() || p != null){
            if(p!= null){
                    s.push(p);
                    p= p.left;
                }else{
                    p = s.pop();
                    ret = p.val;
                    p=p.right;
                    count++;
                if(count == k) break;
            }
        }
        return ret;
    }

    // divide and conquer  1 ms, 53%
    public int kthSmallest2(TreeNode root, int k) {
        int node_rank = countNodes(root.left) + 1;
        if (node_rank == k) return root.val;
        else if (node_rank > k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - node_rank);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }




}
