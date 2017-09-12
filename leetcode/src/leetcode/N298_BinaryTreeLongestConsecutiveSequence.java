package leetcode;

/**
 * Created by Hua on 7/17/2017.

 Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along
 the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,

  1
   \
   3
  / \
 2   4
      \
       5

 Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    /
   2
  /
 1

 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


 */
import leetcode.N0_data_strcture.*;
public class N298_BinaryTreeLongestConsecutiveSequence {
    // Google (Premium)
    // 54 / 54 test cases passed.
    // 4 ms
    // longest increasing consecutive sequence.
    // dfs.
    public class Solution {
        int ret = 0;
        public int longestConsecutive(TreeNode root) {
            if(root == null) return 0;
            dfs(root, 0, root.val);
            return ret;
        }

        public void dfs(TreeNode node, int num, int val){
            if(node == null) return;

            if(val == node.val) num++;
            else num = 1;
            ret = Math.max(ret, num);

            dfs(node.left, num, node.val + 1);
            dfs(node.right, num, node.val + 1);
        }
    }

    // another interesting solution.
    // 54 / 54 test cases passed.
    // 4 ms
    public class Solution2 {
        public int longestConsecutive(TreeNode root) {
            return dfs(root, null, 0);
        }

        private int dfs(TreeNode p, TreeNode parent, int length) {
            if (p == null) return length;
            length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
            return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
        }
    }
}
