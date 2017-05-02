package leetcode;

/**
 * Created by Hua on 5/1/2017.

 Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and
 the sum of all right subtree node values. Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:

 Input:
    1
  /   \
 2     3

 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1

 Note:

 The sum of node values in any subtree won't exceed the range of 32-bit integer.
 All the tilt values won't exceed the range of 32-bit integer.


 */

import leetcode.N0_data_strcture.*;
public class N563_BinaryTreeTilt {
    // 75 / 75 test cases passed.
    // Runtime: 10 ms
    public class Solution {
        int ret = 0;

        public int findTilt(TreeNode root) {
            getSum(root);
            return ret;
        }

        public int getSum(TreeNode node){
            if(node == null) return 0;
            int left = getSum(node.left);
            int right = getSum(node.right);
            ret += Math.abs(left - right);
            return left + right + node.val;
        }
    }

}
