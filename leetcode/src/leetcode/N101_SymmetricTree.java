package leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class N101_SymmetricTree {
	//340 ms  37%
	public boolean isSymmetricHelper(TreeNode l, TreeNode r){
		if(l ==null &&  r==null){
			return true;
		}else if (l !=null && r!=null){ 
			return l.val == r.val && isSymmetricHelper(l.left, r.right) && isSymmetricHelper(l.right,r.left);
		}else{ // l==null r!=null or l!=null r==null
			return false;		
		}
	}
	
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    //iterative, use queue  320 ms  62%
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> l_queue = new LinkedList<TreeNode>();
        Queue<TreeNode> r_queue = new LinkedList<TreeNode>();
        
        l_queue.add(root.left);
        r_queue.add(root.right);
        
        while(!l_queue.isEmpty() && !r_queue.isEmpty()){
        	TreeNode l = l_queue.poll();
        	TreeNode r = r_queue.poll();
        	
        	if(l==null && r==null) continue;
        	else if (l !=null && r!=null){
            	if(l.val != r.val ) return false;
            	l_queue.add(l.left);
            	l_queue.add(l.right);
            	r_queue.add(r.right);
            	r_queue.add(r.left);           		
        		
        	}else return false;
        }
        return true;
    }
}
