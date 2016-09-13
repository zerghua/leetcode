package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.LinkedList;

/**
 * Created by Hua on 3/21/2016.

 Given a binary tree containing digits from 0-9 only,
 each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

   1
  / \
 2   3

 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 */
public class N129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;

        LinkedList<TreeNode> list = new LinkedList<>();
        int sum=0;
        list.add(root);

        while(list.size()>0){
            int current_size = list.size();

            for(int i=0; i<current_size; i++){
                TreeNode node = list.pop();

                if(node.left==null && node.right==null) {
                    sum+= node.val;
                }

                if(node.left != null){
                    node.left.val = node.val*10 + node.left.val;
                    list.add(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val*10 + node.right.val;
                    list.add(node.right);
                }
            }
        }
        return sum;
    }

    public int sumNumbers_recursion_helper(TreeNode root, int num, int sum){
        if(root == null) return sum;

        num = num*10 + root.val;

        if(root.left==null && root.right==null) {
            sum+= num;
            return sum;
        }

        return sumNumbers_recursion_helper(root.left, num, sum) +
                sumNumbers_recursion_helper(root.right, num, sum);

    }

    public int sumNumbers_recursion(TreeNode root) {
        if(root == null) return 0;

        return sumNumbers_recursion_helper(root, 0, 0);
    }

    // version 3  added on 9/13/2016
    // 0 ms, 109 / 109 test cases passed.
    // DFS, return accumulated sum
    public class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        public int dfs(TreeNode node, int sum){
            if(node == null) return 0;
            int ret = sum*10 + node.val;
            if(node.left == null && node.right==null) return ret;
            return dfs(node.left, ret) + dfs(node.right, ret);
        }
    }
}
