package leetcode;

/**
 * Created by Hua on 7/11/2017.

 Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 Example 1:

 Input:
 3
 / \
 9  20
 /  \
 15   7

 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

 Note:

 The range of node's value is in the range of 32-bit signed integer.

 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N637_AverageofLevelsinBinaryTree {
    // Facebook
    // level order binary search
    // 64 / 64 test cases passed.
    // 12 ms
    public class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList();
            list.add(root);
            List<Double> ret = new LinkedList();
            while(!list.isEmpty()){
                int size = list.size();
                long sum = 0;
                for(int i=0; i<size; i++){
                    TreeNode node = list.removeFirst();
                    sum += node.val;
                    if(node.left != null) list.add(node.left);
                    if(node.right != null) list.add(node.right);
                }
                ret.add(1.0 * sum / size);
            }
            return ret;
        }
    }
}
