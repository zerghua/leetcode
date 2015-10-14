package leetcode;
import java.util.*;
import leetcode.N0_data_strcture.*;

// 5 ms
public class N107_BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(root == null) return ret;
    	
        List<List<TreeNode>> bfs_lists = new ArrayList<List<TreeNode>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int level=0;
        bfs_lists.add(level, list);
        
        while(true){
        	LinkedList<TreeNode> new_list = new LinkedList<TreeNode>();
        	for(int i=0;i<bfs_lists.get(level).size();i++){
        		if (bfs_lists.get(level).get(i).left !=null) new_list.add(bfs_lists.get(level).get(i).left);
        		if (bfs_lists.get(level).get(i).right !=null) new_list.add(bfs_lists.get(level).get(i).right);
        	}
        	level++;
        	if (new_list.size() >0) bfs_lists.add(level, new_list);
        	else break;
        	
        }
        
    	// get bottom-up level order traversal
        
        for (int i=bfs_lists.size()-1; i>=0;i--){
        	LinkedList<Integer> new_list = new LinkedList<Integer>();
        	for(int j=0;j<bfs_lists.get(i).size();j++) new_list.add(bfs_lists.get(i).get(j).val);
        	ret.add(new_list);
        }
        return ret;
    }
    
    //3 ms
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(root == null) return ret;    
		
    	LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> next = new LinkedList<TreeNode>();	
    	LinkedList<Integer> num_list = new LinkedList<Integer>();
    	cur.add(root);
    	
    	while(!cur.isEmpty()){
    		TreeNode node =  cur.remove();
    		num_list.add(node.val);
    		
    		if(node.left !=null) next.add(node.left);
    		if(node.right !=null) next.add(node.right);
    		
    		if(cur.isEmpty()){
    			ret.add(num_list);
    			cur = next;
    			next = new LinkedList<TreeNode>();
    			num_list = new LinkedList<Integer>();
    		}
    	}
    	
    	//reverse list
    	List<List<Integer>> reversed_ret = new ArrayList<List<Integer>>();
    	for(int i=ret.size()-1;i>=0;i--){
    		reversed_ret.add(ret.get(i));
    	}
    	
    	return reversed_ret;
    }
}
