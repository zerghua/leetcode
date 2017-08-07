package leetcode;

/**
 * Created by HuaZ on 8/5/2017.

 Given an integer array with no duplicates.
 A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:

 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

    6
  /   \
 3     5
 \    /
  2  0
  \
   1

 Note:

 The size of the given array will be in the range [1,1000].


 */

import leetcode.N0_data_strcture.*;
public class N654_MaximumBinaryTree {
    // leetcode contest 44, passed solution
    // Microsoft
    // 107 / 107 test cases passed.
    // 14 ms
    public class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return dfs(nums, 0, nums.length-1);
        }

        public TreeNode dfs(int[] nums, int lo, int hi){
            if(lo > hi) return null;
            // find max
            int max_index = lo;
            for(int i=lo; i<=hi; i++){
                if(nums[i] > nums[max_index]) max_index = i;
            }
            TreeNode root = new TreeNode(nums[max_index]);
            root.left = dfs(nums, lo, max_index-1);
            root.right = dfs(nums, max_index+1, hi);
            return root;
        }
    }
}
