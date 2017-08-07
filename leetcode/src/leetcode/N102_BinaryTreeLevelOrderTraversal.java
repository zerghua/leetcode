package leetcode;
import java.util.*;
import leetcode.N0_data_strcture.*;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]



 */
public class N102_BinaryTreeLevelOrderTraversal {
    // FaceBook, Amazon, Microsoft.
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


    // version 2, BFS and DFS added on 9/12/2016
    // 2 ms  34 / 34 test cases passed.
    // BFS use queue, store size of each level.
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            Queue<TreeNode> queue  = new LinkedList<>();
            if(root != null) queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> level_list = new ArrayList<>();
                for(int i=0;i<size; i++){
                    TreeNode cur = queue.remove();
                    level_list.add(cur.val);
                    if(cur.left != null) queue.add(cur.left);
                    if(cur.right != null) queue.add(cur.right);
                }
                ret.add(level_list);
            }
            return ret;
        }
    }

    // DFS, pass level as a argument.
    // 1 ms  34 / 34 test cases passed.
    public class Solution_dfs {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            dfs(ret, 0, root);
            return ret;
        }

        public void dfs(List<List<Integer>> ret, int level, TreeNode node){
            if(node == null) return;
            if(level == ret.size()) ret.add(new ArrayList<>());
            ret.get(level).add(node.val);
            dfs(ret, level+1, node.left);
            dfs(ret, level+1, node.right);
        }
    }

}
