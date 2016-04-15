package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by zhanhua on 4/14/2016.
 */
public class N98_ValidateBinarySearchTree {
    //1 ms
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode node, double min, double max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;

        if(isValidBST(node.left, min, node.val) == false) return false;
        if(isValidBST(node.right, node.val, max) == false) return false;

        return true;
    }


    public boolean isValidBST2(TreeNode node, double min, double max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return isValidBST2(node.left, min, node.val) && isValidBST2(node.right, node.val, max);
    }



}
