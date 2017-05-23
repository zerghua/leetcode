package leetcode;

/**
 * Created by Hua on 5/23/2017.

 Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.

 Note: Time complexity should be O(height of tree).

 Example:

 root = [5,3,6,2,4,null,7]
 key = 3

     5
    / \
   3   6
  / \   \
 2   4   7

 Given key to delete is 3. So we find the node with value 3 and delete it.

 One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

     5
    / \
   4   6
  /     \
 2       7

 Another valid answer is [5,2,6,null,4,null,7].

   5
  / \
 2   6
  \   \
  4   7

 Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
 Once the node is found, have to handle the below 4 cases

 1. node doesn't have left or right - return null
 2. node only has left subtree- return the left subtree
 3. node only has right subtree- return the right subtree
 4. node has both left and right - find the minimum value in the right subtree,
 set that value to the currently found node, then recursively delete the minimum value in the right subtree

 */

import leetcode.N0_data_strcture.*;
public class N450_DeleteNodeinaBST {
    // 85 / 85 test cases passed.
    // 7 ms
    // dfs delete node.
    public class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return null;

            // search key
            if(root.val > key) root.left = deleteNode(root.left, key);
            else if(root.val < key) root.right = deleteNode(root.right, key);
            else {
                // found key and remove it
                if(root.left == null) return root.right;
                else if(root.right == null) return root.left;
                else{
                    // find min node of root.right
                    TreeNode node = root.right;
                    while(node.left != null) node = node.left;

                    root.val =node.val;
                    root.right = deleteNode(root.right, node.val);
                }
            }
            return root;
        }
    }
}
