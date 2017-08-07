package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.*;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path
from the root node down to the nearest leaf node.

 */
public class N111_MinimumDepthofBinaryTree {
    // no company
	//1 ms
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left ==null && root.right ==null) return 1;
        if(root.left !=null && root.right !=null) return 1 + Math.min(minDepth(root.left),  minDepth(root.right));
        else if( root.left !=null) return 1 + minDepth(root.left);
        else return 1 + minDepth(root.right);
    }
    
    //1 ms
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left ==null) return 1 + minDepth(root.right);
        else if(root.right ==null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left),  minDepth(root.right));
    }

    //version 3 added on 9/12/2016
    // 1 ms   41 / 41 test cases passed.
    // DFS, return 1+min(dfs(node.left), dfs(node.right))
    public class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null || root.right == null)
                return 1+Math.max(minDepth(root.left), minDepth(root.right));
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    // add BFS solution on 10/8/2016
    // BFS works well when tree is highly unbalanced
    // 1 ms 41 / 41 test cases passed.
    public class Solution_BFS {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int ret = 1;
            boolean isFound=false;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                    if(node.left == null && node.right==null) {
                        isFound = true;
                        break;
                    }
                    if(node.left != null) q.add(node.left);
                    if(node.right!= null) q.add(node.right);
                }
                if(isFound) break;
                ret++;
            }
            return ret;
        }
    }

    // another BFS solution, use rightMost node as indicator of each level
    // 2 ms 41 / 41 test cases passed.
    public class Solution_BFS2 {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int ret = 1;
            TreeNode rightMost=root;
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(node.left == null && node.right==null) break;
                if(node.left != null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
                if(node == rightMost){ // about to next level
                    ret++;
                    rightMost = (node.right == null)? node.left: node.right; // if node.left is null, meaning it's the last level.
                }
            }
            return ret;
        }
    }
}
