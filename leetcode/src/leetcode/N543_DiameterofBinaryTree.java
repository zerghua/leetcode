package leetcode;

/**
 * Created by Hua on 5/5/2017.

 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree

     1
    / \
   2   3
  / \
 4   5

 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.

 */
import leetcode.N0_data_strcture.*;
public class N543_DiameterofBinaryTree {
    // 106 / 106 test cases passed.
    // 11 ms
    // DFS
    public class Solution {
        int max=0;
        public int diameterOfBinaryTree(TreeNode root) {
            getHeight(root);
            return max;
        }

        public int getHeight(TreeNode node){
            if(node == null) return 0;
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            if(left + right > max) max = left + right ;
            return 1 + Math.max(left, right);
        }
    }
}
