package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/*
 *
 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL


Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
    and every parent has two children).

 */
public class N116_PopulatingNextRightPointersinEachNode {
    // Microsoft
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

    // version 2 added 9/12/2016
    // BFS level order traversal solution also works for 117.
    // 5 ms  14 / 14 test cases passed.
    public class Solution {
        public void connect(TreeLinkNode root) {
            Queue<TreeLinkNode> q = new LinkedList<>();
            if(root != null) q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeLinkNode node =q.remove();
                    if(i<size-1) node.next = q.peek(); // extra line for this problem
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
        }
    }


}
