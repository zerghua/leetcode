package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.Stack;

/**
 * Created by Hua on 3/20/2016.
 */
public class N173_BinarySearchTreeIterator {
    Stack<TreeNode> st;

    public N173_BinarySearchTreeIterator(TreeNode root) {
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
