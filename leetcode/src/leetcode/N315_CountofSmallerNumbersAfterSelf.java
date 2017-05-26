package leetcode;

/**
 * Created by Hua on 5/26/2017.

 You are given an integer array nums and you have to return a new counts array.
 The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.

 */
import java.util.*;
public class N315_CountofSmallerNumbersAfterSelf {
    // BF is o(n^2)
    // BST is average o(logn), worst o(n^2)
    // 16 / 16 test cases passed.
    // 13 ms
    public class Solution {
        class TreeNode{
            int val, smallerCount;
            TreeNode left, right;
            TreeNode(int val){
                this.val = val;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            if(nums == null || nums.length == 0) return new LinkedList<>();
            TreeNode root = null;
            Integer ret[] = new Integer[nums.length];
            for(int i=nums.length-1; i>=0; i--){
                root = dfs(nums[i], root, ret, i, 0);  // build BST tree.
            }
            return Arrays.asList(ret);
        }

        public TreeNode dfs(int num, TreeNode node, Integer[] ret, int i, int preCount){
            if(node == null){
                ret[i] = preCount;
                node = new TreeNode(num);
            }else if(num >= node.val){
                node.right = dfs(num, node.right, ret, i, preCount + node.smallerCount + (num > node.val ? 1 : 0));
            }else{
                node.smallerCount++;
                node.left = dfs(num, node.left, ret, i, preCount);
            }
            return node;
        }
    }
}
