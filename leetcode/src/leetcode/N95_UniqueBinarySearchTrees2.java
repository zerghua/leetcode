package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.*;

/**
 * Created by Hua on 3/27/2016.

 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

     1         3     3      2      1
      \       /     /      / \      \
       3     2     1      1   3      2
      /     /       \                 \
     2     1         2                 3



 */
public class N95_UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new LinkedList<>();
        if(start > end){
            ret.add(null);
            return ret;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> lefts= generateTrees(start, i-1);
            List<TreeNode> rights= generateTrees(i+1, end);

            for(TreeNode left: lefts){
                for(TreeNode right: rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ret.add(node);
                }
            }
        }
        return ret;
    }


    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new LinkedList<>();
        return generateTrees(1, n);
    }
}
