package leetcode;

/**
 * Created by HuaZ on 10/16/2016.

 Find the sum of all left leaves in a given binary tree.

 Example:

     3
    / \
   9  20
     /  \
    15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


 */

import leetcode.N0_data_strcture.*;
public class N404_SumofLeftLeaves {
    // Facebook
    // 8 ms  102 / 102 test cases passed.
    public int sumOfLeftLeaves(TreeNode root) {
        if(root ==null) return 0;
        if(root.left != null && root.left.left ==null && root.left.right==null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
