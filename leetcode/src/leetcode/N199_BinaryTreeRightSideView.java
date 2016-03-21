package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 3/20/2016.
 */
public class N199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(q.size() > 0){

            int current_size = q.size();
            for(int i=0; i<current_size; i++){
                TreeNode node = q.pop();

                if(i == 0) ret.add(node.val);

                // add nodes to queue from right to left
                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
        }

        return ret;
    }



}
