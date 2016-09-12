package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/28/2016.

 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class N106_ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int inorder_start, int inorder_end,
                              int[] postorder, int postorder_start, int postorder_end) {
        if(inorder_start == inorder_end) return new TreeNode(inorder[inorder_start]);
        if(inorder_start > inorder_end) return null;

        int root_val = postorder[postorder_end];
        TreeNode root = new TreeNode(root_val);

        int left_tree_length = 0;
        for(int i=inorder_start; i<inorder_end; i++){
            if(inorder[i] == root_val) {
                break;
            }
            left_tree_length++;
        }

        root.left = buildTree(inorder, inorder_start, inorder_start+ left_tree_length -1,
                postorder, postorder_start, postorder_start+left_tree_length -1);

        root.right = buildTree(inorder, inorder_start+ left_tree_length +1, inorder_end,
                postorder, postorder_start+left_tree_length, postorder_end-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1, postorder, 0, postorder.length-1);
    }
}
