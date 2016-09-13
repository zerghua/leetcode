package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/23/2016.

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

     1
    / \
   2   5
  / \   \
 3   4   6

 The flattened tree should look like:

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6

 click to show hints.
 Hints:

 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 */

public class N114_FlattenBinaryTreetoLinkedList {
    //put root's right tree to the right of root's left tree's right-most
    // 1. find root's left tree's right most, and store it
    // 2. set root's right tree to be right of 1
    // 3. set root's left to right
    // 4. set root's left to null
    // 5. if root.left == null, go to right.
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode cur = root, prev;
        while (cur != null) {
            if (cur.left == null) cur = cur.right;
            else {
                prev = cur.left;

                while (prev.right != null) prev = prev.right;

                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }

    //or store pre-order traversal in LinkedList.
}