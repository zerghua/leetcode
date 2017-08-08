package leetcode;
import java.util.LinkedList;
import java.util.*;

import leetcode.N0_data_strcture.*;
/*

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

 */
public class N144_BinaryTreePreorderTraversal {
	// no company
	//iterative 2 ms
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> ret = new LinkedList<Integer>();
    	if(root == null) return ret;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	while(!s.isEmpty()){
    		TreeNode node = s.pop();
    		ret.add(node.val);
    		if(node.right != null)s.push(node.right);
    		if(node.left != null)s.push(node.left);
    	}
    	return ret;
    }	
	
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> ret = new LinkedList<Integer>();
    	preorderTraversal_recur(root, ret);
    	return ret;
    }
    
    //recursion  1 ms
    public void preorderTraversal_recur(TreeNode node, List<Integer> ret){
    	if(node == null) return;
    	ret.add(node.val);
    	preorderTraversal_recur(node.left, ret);
    	preorderTraversal_recur(node.right, ret);
    }
}
