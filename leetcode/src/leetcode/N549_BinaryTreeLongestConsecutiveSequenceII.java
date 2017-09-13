package leetcode;

/**
 * Created by Hua on 7/18/2017.

 Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

 Especially, this path can be either increasing or decreasing.
 For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
 On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

 Example 1:

 Input:
   1
  / \
 2   3
 Output: 2
 Explanation: The longest consecutive path is [1, 2] or [2, 1].

 Example 2:

 Input:
   2
  / \
 1   3
 Output: 3
 Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].

 Note: All the values of tree nodes are in the range of [-1e^7, 1e^7].

 */

import leetcode.N0_data_strcture.*;
public class N549_BinaryTreeLongestConsecutiveSequenceII {
    // Google (Premium)
    // concise code, return two parameters, increase and decrease count
    // 159 / 159 test cases passed.
    // 16 ms
    public class Solution {
        int maxval = 0;
        public int longestConsecutive(TreeNode root) {
            longestPath(root);
            return maxval;
        }
        public int[] longestPath(TreeNode root) {
            if (root == null) return new int[] {0,0};
            int inr = 1, dcr = 1;

            if (root.left != null) {
                int[] l = longestPath(root.left);
                if (root.val == root.left.val + 1)
                    dcr = l[1] + 1;
                else if (root.val == root.left.val - 1)
                    inr = l[0] + 1;
            }

            if (root.right != null) {
                int[] r = longestPath(root.right);
                if (root.val == root.right.val + 1)
                    dcr = Math.max(dcr, r[1] + 1);
                else if (root.val == root.right.val - 1)
                    inr = Math.max(inr, r[0] + 1);
            }

            maxval = Math.max(maxval, dcr + inr - 1);
            return new int[] {inr, dcr};
        }
    }


    // 159 / 159 test cases passed.
    // 13 ms
    // dfs, I wrote too complex code
    public class Solution2 {
        int ret  = 0;
        public int longestConsecutive(TreeNode root) {
            if(root == null) return 0;
            dfs(root, null);
            return ret;
        }

        public int dfs(TreeNode node, Integer val){
            if(node == null) return 0;
            int left = dfs(node.left, node.val);
            int right = dfs(node.right, node.val);

            if(node.left != null && node.right != null &&
                    ((node.right.val - node.val == 1 && node.val - node.left.val == 1) ||
                            (node.right.val - node.val == -1 && node.val - node.left.val == -1))){
                ret = Math.max(ret, 1 +left + right);
            }

            int max = 1;
            if(node.left == null || node.left.val + 1 == node.val || node.left.val - 1 == node.val) {
                ret = Math.max(ret, 1 + left);
                if(node.left == null || val == null || (val - node.val == 1 && node.val - node.left.val == 1)
                        || (val - node.val == -1 && node.val - node.left.val == -1)) max = Math.max(max, 1 + left);
            }

            if(node.right == null || node.right.val + 1 == node.val || node.right.val - 1 == node.val) {
                ret = Math.max(ret, 1 + right);
                if(node.right == null || val == null || (val - node.val == 1 && node.val - node.right.val == 1)
                        || (val - node.val == -1 && node.val - node.right.val == -1)) max = Math.max(max, 1 + right);
            }

            return max;
        }
    }



}
