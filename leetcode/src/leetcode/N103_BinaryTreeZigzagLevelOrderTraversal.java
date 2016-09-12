package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.*;

/**
 * Created by Hua on 3/28/2016.

 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7

 return its zigzag level order traversal as:

 [
     [3],
     [20,9],
     [15,7]
 ]



 */
public class N103_BinaryTreeZigzagLevelOrderTraversal {
    // two stack solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret =  new LinkedList<List<Integer>>();
        if(root==null) return ret;

        Stack<TreeNode> left_stack = new Stack<TreeNode>();
        Stack<TreeNode> right_stack = new Stack<TreeNode>();
        left_stack.push(root);

        while(!left_stack.isEmpty() || !right_stack.isEmpty()){
            if(!left_stack.isEmpty()){
                List<Integer> ret_list = new LinkedList<>();
                while(!left_stack.isEmpty()){
                    TreeNode node = left_stack.pop();
                    if(node.left !=null) right_stack.push(node.left);
                    if(node.right !=null) right_stack.push(node.right);
                    ret_list.add(node.val);
                }
                ret.add(ret_list);
            }else{
                List<Integer> ret_list2 = new LinkedList<>();
                while(!right_stack.isEmpty()){
                    TreeNode node = right_stack.pop();
                    if(node.right !=null) left_stack.push(node.right);
                    if(node.left !=null) left_stack.push(node.left);
                    ret_list2.add(node.val);
                }
                ret.add(ret_list2);
            }
        }

        return ret;
    }

    // on 9/12/2016
    //another solution could be 102, level order traversal and then reverse odd list in ret.
    //as  Collections.reverse(res.get(i));  for each odd number list.
}
