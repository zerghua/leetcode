package leetcode;
import java.util.Stack;

import leetcode.N0_data_strcture.*;

public class N226_invertTree {
	
	//260ms 81%
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        else {
        	TreeNode tmp = invertTree(root.left);
        	root.left = invertTree(root.right);
        	root.right = tmp;
        	return root;        
        }
    }
    
    //iterative   268 ms 70%
    public TreeNode invertTree2(TreeNode root) {
    	if(root == null) return root;
    	
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	
    	while(!s.isEmpty())
    	{
    		TreeNode node = s.pop();
    		
    		//swap left and right of node
    		TreeNode tmp = node.left;
    		node.left = node.right;
    		node.right = tmp;
    		
    		if(node.left !=null ) s.push(node.left);
    		if(node.right !=null ) s.push(node.right);
    	}
    	
    	return root;
    }
    
}
