package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/*
 *  Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
    and every parent has two children).

 */
public class N116_PopulatingNextRightPointersinEachNode {
	//6 ms
    public void connect(TreeLinkNode root) {
    	if(root ==null)return;
    	Stack<TreeLinkNode> s = new Stack<TreeLinkNode>();
    	s.push(root);
    	while(!s.isEmpty()){
    		TreeLinkNode node = s.pop();
    		if(node.left!=null && node.right!=null) {
    			node.left.next = node.right;
    			s.push(node.left);
    			s.push(node.right);
    		}
    		
    		//link siblings
    		if(node.next != null && node.left!=null) node.right.next = node.next.left;
    	}
    }
}
