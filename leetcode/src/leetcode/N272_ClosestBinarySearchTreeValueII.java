package leetcode;

/**
 * Created by Hua on 7/26/2017.

 Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:

 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?


 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N272_ClosestBinarySearchTreeValueII {
    // google
    // 68 / 68 test cases passed.
    // 3 ms
    // inorder traversal with early return less than o(n)
    public class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            LinkedList<Integer> ret = new LinkedList();
            dfs(root, target, k, ret);
            return ret;
        }

        public boolean dfs(TreeNode node, double target, int k, LinkedList<Integer> ret){
            if(node == null) return false;                   // not found k yet
            if(dfs(node.left, target, k , ret)) return true; // early return

            if(ret.size() == k){
                if(Math.abs(target - ret.getFirst()) < Math.abs(target - node.val)) return true; // early return
                else ret.removeFirst();
            }

            ret.add(node.val);
            return dfs(node.right, target, k, ret);
        }
    }

}
