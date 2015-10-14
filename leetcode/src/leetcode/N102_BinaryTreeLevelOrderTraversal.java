package leetcode;
import java.util.*;

public class N102_BinaryTreeLevelOrderTraversal {
	//3 ms
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ret =  new LinkedList<List<Integer>>();
    	if(root == null) return ret;
    	
    	LinkedList<TreeNode> cur_list = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> child_list = new LinkedList<TreeNode>();
    	cur_list.add(root);
    	
    	LinkedList<Integer> num_list = new LinkedList<Integer>();
    	while(!cur_list.isEmpty()){
    		TreeNode node = cur_list.remove();
    		num_list.add(node.val);
    		if(node.left != null) child_list.add(node.left);
    		if(node.right != null) child_list.add(node.right);
    		
    		if(cur_list.isEmpty()){
    			ret.add(num_list);
    			cur_list = child_list;
    			child_list = new LinkedList<TreeNode>();
    			num_list = new LinkedList<Integer>();
    		}
    	}
    	return ret;
    }
}
