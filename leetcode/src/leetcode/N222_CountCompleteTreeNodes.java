package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.ArrayList;

/**
 * Created by Hua on 6/9/2016.

 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.

 */
public class N222_CountCompleteTreeNodes {
    // no company
    // brute force, TLE for large data set.
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        int ret=1;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode tmp = list.remove(0);
            if(tmp.left !=null) list.add(tmp.left);
            if(tmp.right!=null) list.add(tmp.right);
            ret++;
        }
        return ret;
    }

    // recursion
    // TLE
    public int countNodes3(TreeNode root) {
        if(root == null) return 0;
        TreeNode leftNode = root.left, rightNode=root.right;
        int left_height=0, right_height=0;
        while(leftNode != null){
            leftNode = leftNode.left;
            left_height++;
        }
        while(rightNode != null){
            rightNode = rightNode.right;
            right_height++;
        }
        if(left_height == right_height){
            int ret=1;
            for(int i=1; i<=left_height;i++){
                ret+= Math.pow(2,i);
            }
            return ret;
        }
        // left_height > right_height
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }

    // TLE
    public int countNodes4(TreeNode root) {
        if(root == null) return 0;
        TreeNode leftNode = root, rightNode=root;
        int left_height=0, right_height=0;
        while(leftNode != null){
            leftNode = leftNode.left;
            left_height++;
        }
        while(rightNode != null){
            rightNode = rightNode.right;
            right_height++;
        }
        if(left_height == right_height){
            return (int)Math.pow(2,left_height) -1;
        }
        // left_height > right_height
        return countNodes4(root.left) + countNodes4(root.right) + 1;
    }

    //133 ms
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode leftNode = root, rightNode=root;
        int left_height=0, right_height=0;
        while(leftNode != null){
            leftNode = leftNode.left;
            left_height++;
        }
        while(rightNode != null){
            rightNode = rightNode.right;
            right_height++;
        }
        if(left_height == right_height){
            return (1<<left_height) -1;
        }
        // left_height > right_height
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //94 ms
    public int countNodes5(TreeNode root) {
        if(root == null) return 0;
        int left_height = getLeftHeight(root.left);
        int right_height = getLeftHeight(root.right);
        if(left_height == right_height) return (1<<left_height) + countNodes5(root.right);
        else return (1<<right_height) + countNodes5(root.left);
    }

    private int getLeftHeight(TreeNode node){
        int h=0;
        while(node!=null){
            node = node.left;
            h++;
        }
        return h;
    }


}
