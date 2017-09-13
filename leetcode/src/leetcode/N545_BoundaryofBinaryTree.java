package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 7/22/2017.


 Given a binary tree, return the values of its boundary in anti-clockwise direction starting
 from root. Boundary includes left boundary, leaves, and right boundary in order without
 duplicate nodes.

 Left boundary is defined as the path from root to the left-most node.
 Right boundary is defined as the path from root to the right-most node.
 If the root doesn't have left subtree or right subtree,
 then the root itself is left boundary or right boundary.
 Note this definition only applies to the input binary tree, and not applies to any subtrees.

 The left-most node is defined as a leaf node you could reach when you always firstly
 travel to the left subtree if exists. If not, travel to the right subtree.
 Repeat until you reach a leaf node.

 The right-most node is also defined by the same way with left and right exchanged.

 Example 1

 Input:
 1
  \
   2
  / \
 3   4

 Ouput:
 [1, 3, 4, 2]

 Explanation:
 The root doesn't have left subtree, so the root itself is left boundary.
 The leaves are node 3 and 4.
 The right boundary are node 1,2,4. Note the anti-clockwise direction means you
 should output reversed right boundary.
 So order them in anti-clockwise without duplicates and we have [1,3,4,2].

 Example 2

 Input:
       ____1_____
      /          \
     2            3
    / \          /
   4   5        6
  / \         / \
 7   8       9  10

 Ouput:
 [1,2,4,7,8,9,10,6,3]

 Explanation:
 The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 The leaves are node 4,7,8,9,10.
 The right boundary are node 1,3,6,10. (10 is the right-most node).
 So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].


 */
import leetcode.N0_data_strcture.*;
public class N545_BoundaryofBinaryTree {
    // Amazon, Google (Premium)
    // awesome question, needs to be very clear on top-down and bottom-up dfs.
    // DFS, very smart structure to handle many corner cases.
    // 117 / 117 test cases passed.
    // 13 ms
    public class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> ret = new LinkedList();
            if(root == null) return ret;

            ret.add(root.val);
            left(root.left, ret);
            leaf(root.left, ret);
            leaf(root.right, ret);
            right(root.right, ret);
            return ret;
        }

        // top-down DFS, left visit first
        public void left(TreeNode node, List<Integer> ret){
            if(node == null || (node.left == null && node.right == null)) return;  // not add the left most leaf
            ret.add(node.val);
            if(node.left != null) left(node.left, ret);
            else left(node.right, ret);
        }

        public void leaf(TreeNode node, List<Integer> ret){
            if(node == null) return;
            if(node.left == null && node.right == null) ret.add(node.val);
            leaf(node.left, ret);
            leaf(node.right, ret);
        }

        // bottom up DFS, also the visit sequence matters, right first
        public void right(TreeNode node, List<Integer> ret){
            if(node == null || (node.left == null && node.right == null)) return;   // not add the right most leaf
            if(node.right != null) right(node.right, ret);
            else right(node.left, ret);
            ret.add(node.val);
        }

    }
}
