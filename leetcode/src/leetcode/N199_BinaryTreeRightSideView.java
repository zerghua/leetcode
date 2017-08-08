package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 3/20/2016.

 Given a binary tree, imagine yourself standing on the right side of it,
 return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,

    1            <---
  /   \
 2     3         <---
  \     \
   5     4       <---

 You should return [1, 3, 4].

 */
public class N199_BinaryTreeRightSideView {
    // Amazon
    // 210 / 210 test cases passed.
    // 2 ms
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(q.size() > 0){

            //use current queue size as level indicator
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
