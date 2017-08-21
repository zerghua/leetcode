package leetcode;

/**
 * Created by Hua on 8/21/2017.

 Given a binary tree with n nodes, your task is to check if it's possible
 to partition the tree to two trees which have the equal sum of values
 after removing exactly one edge on the original tree.

 Example 1:

 Input:
   5
  / \
 10 10
   /  \
  2   3

 Output: True
 Explanation:
   5
  /
 10

 Sum: 15

   10
  /  \
 2    3

 Sum: 15

 Example 2:

 Input:
   1
  / \
 2  10
   /  \
  2   20

 Output: False
 Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.

 Note:

 The range of tree node value is in the range of [-100000, 100000].
 1 <= n <= 10000


 */
import leetcode.N0_data_strcture.*;

public class N663_EqualTreePartition {
    // DFS bottom up, trick is figure out two equal parts means find half of the total.
    // 194 / 194 test cases passed.
    // 13 ms
    class Solution {
        boolean ret = false;
        public boolean checkEqualTree(TreeNode root) {
            int sum = getSum(root);
            if(Math.abs(sum) % 2 == 1 || (root.left == null && root.right == null)) return false;
            dfs(root, sum/2);
            return ret;
        }

        public int getSum(TreeNode node){
            if(node == null) return 0;
            return node.val + getSum(node.left) + getSum(node.right);
        }

        public int dfs(TreeNode node, int sum){
            if(node == null) return 0;
            int left = dfs(node.left, sum);
            int right = dfs(node.right, sum);
            if(node.val + left + right == sum) ret = true;
            return node.val + left + right;
        }
    }
}
