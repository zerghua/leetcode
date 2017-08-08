package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.Stack;

/**
 * Created by Hua on 3/20/2016.

 Implement an iterator over a binary search tree (BST).
 Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 where h is the height of the tree.
 */

    // the reason the time is average o(1)
    // because each element is in stack once and pop out once, without extra looking.
public class N173_BinarySearchTreeIterator {
    // Google, Facebook, Microsoft
    // 61 / 61 test cases passed.
    // 6 ms
    public class BSTIterator {
        Stack<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new Stack<TreeNode>();
            while(root != null){
                st.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !st.empty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode ret_node = st.pop();
            if(ret_node.right!=null){
                TreeNode tmp = ret_node.right;
                while(tmp != null){
                    st.push(tmp);
                    tmp=tmp.left;
                }
            }

            return ret_node.val;
        }
    }
}
