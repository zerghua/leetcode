package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by HuaZ on 9/5/2017.

 Given a binary tree, write a function to erase a list of nodes from the tree
 and return the forest created from this operation
 Example:

           1
        /    \
      2       3
    /  \     /  \
   4    5   6    7

 Erase(4, 3)

 output: 3 trees

   1       6        7
  /
 2
 \
  5

 */
public class A_BinaryTreeDeleteNode {
    List<TreeNode> ret;
    public List<TreeNode> deleteNode(TreeNode root, HashSet<TreeNode> set){
        ret = new LinkedList();
        dfs(root, set, null);
        return ret;
    }

    public void dfs(TreeNode node, HashSet<TreeNode> set, TreeNode parent){
        if(node == null) return;
        if(!set.contains(node)){
            if(parent == null) ret.add(node);

            if(node.left != null){
                if(set.contains(node.left)) {
                    dfs(node.left, set, null);
                    node.left = null;
                }else dfs(node.left, set, node);
            }

            if(node.right != null){
                if(set.contains(node.right)) {
                    dfs(node.right, set, null);
                    node.right = null;
                }else dfs(node.right, set, node);
            }
        }else{
            dfs(node.left, set, null);
            dfs(node.right, set, null);
        }
    }
}
