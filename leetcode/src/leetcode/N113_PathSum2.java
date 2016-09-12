package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 4/1/2016.

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

       5
      / \
     4   8
    /   / \
   11  13  4
  /  \    / \
 7    2  5   1

 return

 [
     [5,4,11,2],
     [5,8,4,5]
 ]

 */
public class N113_PathSum2 {
    //31 ms  -> 4 ms
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        pathSum(root, sum, ret, new LinkedList<Integer>());
        return ret;
    }

    private void pathSum(TreeNode root, int sum,
                         List<List<Integer>> ret, LinkedList<Integer> list) {
        if(root == null) return;


        if(sum == root.val && root.left==null && root.right==null){ // make sure it's root to leaf
            LinkedList<Integer> ret_list = new LinkedList<Integer>(list);
            ret_list.add(root.val);
            ret.add(ret_list);
            return;
        }

        if(root.left != null) {
            list.add(root.val);
            pathSum(root.left, sum - root.val, ret, list);
            list.removeLast();
        }

        if(root.right != null) {
            list.add(root.val);
            pathSum(root.right, sum - root.val, ret, list);
            list.removeLast();
        }
    }
}
