package leetcode;

/**
 * Created by Hua on 5/12/2017.

 Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:

 Input:

   2
  / \
 1   3

 Output:
 1

 Example 2:

 Input:

      1
     / \
    2   3
   /   / \
  4   5   6
    /
   7

 Output:
 7

 Note: You may assume the tree (i.e., the given root node) is not NULL.

 */

import leetcode.N0_data_strcture.*;
import java.util.LinkedList;
import java.util.Queue;

public class N513_FindBottomLeftTreeValue {
    // Microsoft
    // BFS level order traversal.
    // 74 / 74 test cases passed.
    // 12 ms
    public class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            int ret = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size; i++){
                    TreeNode n = q.remove();
                    if(i == 0) ret = n.val;
                    if(n.left != null) q.add(n.left);
                    if(n.right != null) q.add(n.right);
                }
            }
            return ret;
        }
    }
}
