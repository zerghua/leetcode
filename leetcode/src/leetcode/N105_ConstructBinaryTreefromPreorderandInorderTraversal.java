package leetcode;
import leetcode.N0_data_strcture.*;


/**
 * Created by Hua on 3/28/2016.
 */
public class N105_ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preorder_start, int preorder_end,
                              int[] inorder, int inorder_start, int inorder_end) {
        if(preorder_end < preorder_start) return null;
        if(preorder_end == preorder_start) return new TreeNode(preorder[preorder_end]);

        int root_val = preorder[preorder_start];
        TreeNode root = new TreeNode(root_val);

        int left_tree_length=0;
        for(int i=inorder_start; i<inorder_end; i++){
            if(inorder[i] == root_val) break;
            left_tree_length++;
        }

        root.left = buildTree(preorder, preorder_start+1, preorder_start+left_tree_length,
                inorder, inorder_start, inorder_start+left_tree_length-1);

        root.right = buildTree(preorder, preorder_start+left_tree_length+1, preorder_end,
                inorder, inorder_start+left_tree_length+1, inorder_end);

        return root;
    }
}
