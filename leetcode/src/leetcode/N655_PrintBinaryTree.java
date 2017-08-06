package leetcode;

/**
 * Created by HuaZ on 8/5/2017.

 Print a binary tree in an m*n 2D string array following these rules:

 The row number m should be equal to the height of the given binary tree.
 The column number n should always be an odd number.
 The root node's value (in string format) should be put in the exactly middle of the
 first row it can be put. The column and the row where the root node belongs
 will separate the rest space into two parts (left-bottom part and right-bottom part).
 You should print the left subtree in the left-bottom part and print the right subtree
 in the right-bottom part. The left-bottom part and the right-bottom part should have the same size.
 Even if one subtree is none while the other is not,
 you don't need to print anything for the none subtree but still need to leave the space
 as large as that for the other subtree. However, if two subtrees are none,
 then you don't need to leave space for both of them.
 Each unused space should contain an empty string "".
 Print the subtrees following the same rules.

 Example 1:

 Input:
   1
  /
 2
 Output:
 [["", "1", ""],
 ["2", "", ""]]

 Example 2:

 Input:
   1
  / \
 2   3
 \
  4
 Output:
 [["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]

 Example 3:

 Input:
       1
      / \
     2   5
    /
   3
  /
 4
 Output:

 [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]

 Note: The height of binary tree is in the range of [1, 10].

 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N655_PrintBinaryTree {
    // leetcode contest 44, passed solution
    public class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int h = dfs(root); // get height of tree
            int col = (int)Math.pow(2, h) - 1;

            List<List<String>> ret = new ArrayList();
            build(root, ret, 0, col-1, 0);
            // add trailing ""
            for(List<String> list : ret){
                if(list.size() < col){
                    int size = list.size();
                    for(int i=size;i<col;i++) list.add("");
                }
            }
            return ret;
        }

        public void build(TreeNode node, List<List<String>> ret, int lo, int hi, int level){
            int mid = lo + (hi - lo)/2;
            if(ret.size() <= level) ret.add(new ArrayList());
            if(ret.get(level).size() < lo){
                for(int i=ret.get(level).size(); i<lo; i++) ret.get(level).add("");
            }

            for(int i=lo; i<mid; i++) ret.get(level).add("");
            ret.get(level).add(node != null ?"" + node.val : "");
            for(int i=lo; i<mid; i++) ret.get(level).add("");

            if(node == null || (node.left == null && node.right == null)) return;
            build(node.left, ret, lo, mid-1, level+1);
            if(ret.get(level+1).size() <= mid){
                for(int i=ret.get(level+1).size(); i<=mid; i++) ret.get(level+1).add("");
            }
            build(node.right, ret, mid+1, hi, level+1);
        }

        public int dfs(TreeNode node){
            if(node == null) return 0;
            return 1 + Math.max(dfs(node.left), dfs(node.right));
        }
    }
}
