package leetcode;

/**
 * Created by Hua on 7/18/2017.

 You need to construct a binary tree from a string consisting of parenthesis and integers.

 The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

 You always start to construct the left child node of the parent first if it exists.

 Example:

 Input: "4(2(3)(1))(6(5))"
 Output: return the tree root node representing the following tree:

      4
    /   \
   2     6
  / \   /
 3   1 5

 Note:

 There will only be '(', ')' and '0' ~ '9' in the input string.
 An empty tree is represented by "" instead of "()".

 */

import leetcode.N0_data_strcture.*;
public class N536_ConstructBinaryTreefromString {
    // Amazon
    // 86 / 86 test cases passed.
    // 62 ms
    // build tree(dfs) and string parsing.
    public class Solution {
        public TreeNode str2tree(String s) {
            if(s == null || s.length() == 0) return null;
            int firstLeftP = s.indexOf("(");
            int val = (firstLeftP == -1) ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstLeftP));
            TreeNode root = new TreeNode(val);
            if(firstLeftP == -1) return root;
            int start = firstLeftP, p = 0;
            for(int i = start; i< s.length(); i++){
                if(s.charAt(i) == '(') p++;
                else if(s.charAt(i) == ')') p--;

                if(p == 0 && start == firstLeftP) {
                    root.left = str2tree(s.substring(start+1, i));
                    start = i+1;
                }
                else if(p == 0) root.right = str2tree(s.substring(start+1, i));
            }
            return root;
        }
    }
}
