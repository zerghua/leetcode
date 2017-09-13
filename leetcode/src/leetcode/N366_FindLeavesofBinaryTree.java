package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Given a binary tree, collect a tree's nodes as if you were doing this:
 Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree

     1
    / \
   2   3
  / \
 4   5

 Returns [4, 5, 3], [2], [1].

 Explanation:

 1. Removing the leaves [4, 5, 3] would result in this tree:

   1
  /
 2

 2. Now removing the leaf [2] would result in this tree:

 1

 3. Now removing the leaf [1] would result in the empty tree:

 []

 Returns [4, 5, 3], [2], [1].



 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N366_FindLeavesofBinaryTree {
    // Linkedin (Premium)
    // 68 / 68 test cases passed.
    // 1 ms
    // BFS, check left's children and right's children
    public class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> ret = new ArrayList();
            while(root != null) {
                ArrayList<Integer> list = new ArrayList();
                root = dfs(root, list);
                ret.add(list);
            }
            return ret;
        }

        public TreeNode dfs(TreeNode node, ArrayList<Integer> list ){
            if(node == null) return null;
            if(node.left == null && node.right == null){
                list.add(node.val);
                return null;
            }

            if(node.left != null && node.left.left == null && node.left.right == null){
                list.add(node.left.val);
                node.left = null;
            }else node.left = dfs(node.left, list);

            if(node.right != null && node.right.left == null && node.right.right == null){
                list.add(node.right.val);
                node.right = null;
            }else node.right = dfs(node.right, list);

            return node;
        }
    }

    // another interesting solution
    public class Solution2 {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            height(root, res);
            return res;
        }
        private int height(TreeNode node, List<List<Integer>> res){
            if(null==node)  return -1;
            int level = 1 + Math.max(height(node.left, res), height(node.right, res));
            if(res.size()<level+1)  res.add(new ArrayList<>());
            res.get(level).add(node.val);
            return level;
        }
    }
}
