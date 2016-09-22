package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 6/2/2016.
 *
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined
 between two nodes v and w as the lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).��

           _______3______
          /              \
      ___5__          ___1__
     /      \        /      \
    6       2       0       8
  /  \
 7   4

 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 Another example is LCA of nodes 5 and 4 is 5, since a node can be a
 descendant of itself according to the LCA definition.


 */
public class N236_LowestCommonAncestorofaBinaryTree {
    //13 ms
    // top to bottom,
    // if current node left and right children contains each of q and p, then return current;
    // else if one of them is returned, then that one is the result.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right!=null) return root;
        return right == null? left: right;
    }
}
