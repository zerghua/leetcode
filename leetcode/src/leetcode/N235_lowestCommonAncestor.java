package leetcode;
import leetcode.N0_data_strcture.*;

/*

 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T
that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

 */

//this is Binary Search Tree, can be improved
public class N235_lowestCommonAncestor {
    // Amazon, Microsoft, Facebook
    // BST property
    // 27 / 27 test cases passed.
    // 8 ms
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while(root!=null){
                if(root.val < p.val && root.val < q.val)       root = root.right;
                else if(root.val > p.val && root.val > q.val)  root = root.left;
                else return root;
            }
            return null;
        }
    }


	// 504 ms 33%
    // this is for general binary tree, BST can be faster, see above
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        TreeNode node_left = lowestCommonAncestor(root.left, p , q);
        TreeNode node_right = lowestCommonAncestor(root.right, p , q);
        
        if(node_left!=null && node_right!=null) return root;
        else return node_left!=null ? node_left:node_right;
    }	
    
    // 488 ms 50%

    
}
