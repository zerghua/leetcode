package leetcode;
import leetcode.N0_data_strcture.*;



//this is Binary Search Tree, can be improved
public class N235_lowestCommonAncestor {
	//504 ms 33% 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        TreeNode node_left = lowestCommonAncestor(root.left, p , q);
        TreeNode node_right = lowestCommonAncestor(root.right, p , q);
        
        if(node_left!=null && node_right!=null) return root;
        else return node_left!=null ? node_left:node_right;
    }	
    
    // 488 ms 50%
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    	while(root!=null){
    		if(root.val < p.val && root.val < q.val)       root = root.right;
    		else if(root.val > p.val && root.val > q.val)  root = root.left;    			
    		else return root;
    	}
    	return null;
    }	    
    
}
