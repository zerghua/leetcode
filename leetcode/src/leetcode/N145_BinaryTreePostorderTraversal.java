package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 4/18/2016.

 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
  \
   2
  /
 3

 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?

 */
public class N145_BinaryTreePostorderTraversal {
    // no company
    //1 ms
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorderTraversal_recur(root, ret);
        return ret;
    }

    public void postorderTraversal_recur(TreeNode node, List<Integer> ret){
        if(node == null)return;
        postorderTraversal_recur(node.left, ret);
        postorderTraversal_recur(node.right, ret);
        ret.add(node.val);
    }

    //2 ms, very easy to understand, but will modify tree.
    public List<Integer> postorderTraversal_iteratively(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode tmp = s.peek();
            if(tmp.left == null && tmp.right == null){
                ret.add(s.pop().val);
            }

            if(tmp.right != null){
                s.push(tmp.right);
                tmp.right = null;
            }

            if(tmp.left != null){
                s.push(tmp.left);
                tmp.left = null;
            }
        }
        return ret;
    }

    //2ms
    public List<Integer> postorderTraversal_iteratively2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root, pre = null;
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || cur != null){
            if(cur != null) {
                s.push(cur);
                cur=cur.left;
            }else{
                TreeNode tmp = s.peek();
                if(tmp.right != null && tmp.right != pre) cur = tmp.right;
                else {
                    ret.add(tmp.val);
                    pre = s.pop();
                }
            }
        }
        return ret;
    }
}
