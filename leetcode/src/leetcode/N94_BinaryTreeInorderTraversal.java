package leetcode;
import java.util.*;
import leetcode.N0_data_strcture.*;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

 */
public class N94_BinaryTreeInorderTraversal {
	
	// iterative non extra space  2 ms
    public List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> ret = new LinkedList<Integer>();
    	if(root == null) return ret;
    	Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
    	
    	while(!s.isEmpty() || p != null){
    		if(p != null){
    			s.push(p);
    			p = p.left;
    		}else{ // p is null
    			p = s.pop();
    			ret.add(p.val);
        		p = p.right;	
    		}
    	}
    	return ret;
    }		
	
	
	//iterative 2 ms, extra space
    public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> ret = new LinkedList<Integer>();
    	if(root == null) return ret;
    	
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	HashSet<TreeNode> hs = new HashSet<TreeNode>();
    	s.push(root);
    	
    	while(!s.isEmpty()){
    		TreeNode node = s.pop();
    		if(node.left != null && !hs.contains(node)){
    			s.add(node);
    			hs.add(node);
    			s.add(node.left);
    		}else{
    			ret.add(node.val);
        		if(node.right != null)s.push(node.right);			
    		}
    	}
    	return ret;
    }	
	
	
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ret = new LinkedList<Integer>();
    	inorderTraversal_recur(root, ret);
    	return ret;
    }
    
    //recursion  1 ms
    public void inorderTraversal_recur(TreeNode node, List<Integer> ret){
    	if(node == null) return;
    	inorderTraversal_recur(node.left, ret);
    	ret.add(node.val);
    	inorderTraversal_recur(node.right, ret);
    }
}
