package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.*;

/**
 * Created by Hua on 3/28/2016.
 */
public class N103_BinaryTreeZigzagLevelOrderTraversal {
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
}
