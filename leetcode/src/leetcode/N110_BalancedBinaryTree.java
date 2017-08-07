package leetcode;
import leetcode.N0_data_strcture.*;
/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 */
public class N110_BalancedBinaryTree {
    // Bloomberg
	//404 ms 23%,  360ms 71%
	public int getHeight(TreeNode root){
		if(root == null) return 0;
		
		int left = getHeight(root.left);
		if(left == -1) return -1;
		
		int right = getHeight(root.right);
		if(right ==-1 || Math.abs(left-right) > 1) return -1;

		return 1+ Math.max(left, right);
	}
	
	public boolean isBalanced(TreeNode root) {
		if(getHeight(root) == -1) return false;
		return true;
	}

	// added on 10/16/2016
	// 1 ms 226 / 226 test cases passed.
	public class Solution {
		public int dfs(TreeNode root){
			if(root == null) return 0;

			int left = dfs(root.left);
			if(left == -1) return -1;

			int right = dfs(root.right);
			if(right ==-1 || Math.abs(left-right) > 1) return -1;

			return 1+ Math.max(left, right);
		}

		public boolean isBalanced(TreeNode root) {
			return dfs(root) >= 0;
		}
	}

		/*  this is special case only compares depth difference from root, should consider every node
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public int minDepth(TreeNode root){
		if(root == null) return 0;
		return 1+ Math.min(minDepth(root.left), minDepth(root.right));
	}


    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) - minDepth(root) <=1);
    }
    */
}
