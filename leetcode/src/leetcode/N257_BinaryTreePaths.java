package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/*
 Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

 */


public class N257_BinaryTreePaths {
	// Google, Facebook, Apple
	//2 ms, 3 ms
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> ret = new LinkedList<String>();   
    	if(root ==null) return ret; 	
    	binaryTreePaths_helper(root, "", ret); 	
        return ret;
    }
    
    public void binaryTreePaths_helper(TreeNode root, String s, List<String> list){
    	if(root == null) return;
    	s += String.valueOf(root.val) +  "->" ;
    	if(root.left==null && root.right==null) {
    		s=s.substring(0, s.lastIndexOf("->"));
    		list.add(s);
    		return;
    	}
    	binaryTreePaths_helper(root.left, s, list);
    	binaryTreePaths_helper(root.right, s, list);
    }
}
