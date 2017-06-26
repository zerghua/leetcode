package leetcode;

/**
 * Created by Hua on 6/26/2017.

 Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the
 given depth d. The root node is at depth 1.

 The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree
 should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of
 the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with
 value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

 Example 1:

 Input:
 A binary tree as following:
      4
    /   \
   2     6
  / \   /
 3   1 5

 v = 1

 d = 2

 Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5

 Example 2:

 Input:
 A binary tree as following:
     4
    /
   2
  / \
 3   1

 v = 1

 d = 3

 Output:
       4
      /
     2
    / \
   1   1
  /     \
 3       1


 Note:

 The given d is in range [1, maximum depth of the given tree + 1].
 The given binary tree has at least one tree node.

 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N623_AddOneRowtoTree {
    // BFS
    // 109 / 109 test cases passed.
    // 11 ms
    public class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            d--;
            if(d == 0){
                TreeNode n = new TreeNode(v);
                n.left = root;
                return n;
            }

            int level = 1;
            LinkedList<TreeNode> list = new LinkedList();
            list.add(root);
            while(!list.isEmpty() && level <= d){
                int size = list.size();
                for(int i=0; i< size; i++){
                    TreeNode node = list.removeFirst();
                    if(node.left != null) list.add(node.left);
                    if(node.right != null) list.add(node.right);

                    if(d == level){
                        TreeNode new_left = new TreeNode(v);
                        new_left.left = node.left;
                        node.left = new_left;

                        TreeNode new_right = new TreeNode(v);
                        new_right.right = node.right;
                        node.right = new_right;
                    }
                }
                level++;
            }
            return root;
        }
    }
}
