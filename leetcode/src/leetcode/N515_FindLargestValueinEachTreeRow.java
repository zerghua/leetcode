package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/12/2017.

 You need to find the largest value in each row of a binary tree.

 Example:

 Input:

     1
    / \
   3   2
  / \   \
 5   3   9

 Output: [1, 3, 9]

 */

import leetcode.N0_data_strcture.*;
public class N515_FindLargestValueinEachTreeRow {
    // Linkedin
    // BFS, level order traversal, use size of each level to separate.
    // 78 / 78 test cases passed.
    // 13 ms
    public class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ret = new ArrayList();
            if(root == null) return ret;

            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size(), max=Integer.MIN_VALUE;
                for(int i=0;i<size; i++){
                    TreeNode n = q.remove();
                    max = Math.max(max, n.val);
                    if(n.left != null) q.add(n.left);
                    if(n.right != null) q.add(n.right);
                }
                ret.add(max);
            }
            return ret;
        }
    }
}
