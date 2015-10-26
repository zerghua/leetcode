package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class N108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    //old //1 ms
    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right){
        if(left <= right) {
            TreeNode node = new TreeNode(0);
            int mid = left + (right - left)/2;
            node.val = nums[mid];
            if(left == right){
                node.left =null;
                node.right=null;
            }else {
                node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
                node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
            }
            return node;
        }else return null;
    }

    //improved code 1 ms
    public TreeNode sortedArrayToBSTHelper2(int[] nums, int left, int right){
        if (left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return node;
    }

}
