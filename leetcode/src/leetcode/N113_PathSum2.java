package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 4/1/2016.
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
