package leetcode;

/**
 * Created by Hua on 5/15/2017.

 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element)
 in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.

 For example:
 Given BST [1,null,2,2],

 1
 \
 2
 /
 2

 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space
 incurred due to recursion does not count).

 */

import leetcode.N0_data_strcture.*;
import java.util.*;

public class N501_FindModeinBinarySearchTree {
    // Google
    // similar to N508, most frequent subtree sum.
    // 25 / 25 test cases passed.
    // 25 ms
    public class Solution {
        int maxCount = 0;
        public int[] findMode(TreeNode root) {
            HashMap<Integer, Integer> map = new HashMap();
            dfs(root, map);  // get count of each value

            ArrayList<Integer> list = new ArrayList();
            for(int key : map.keySet()){
                if(map.get(key) == maxCount) list.add(key);
            }

            int[] ret =new int[list.size()];
            for(int i=0; i<list.size(); i++) ret[i] = list.get(i);
            return ret;
        }

        public void dfs(TreeNode node, HashMap<Integer, Integer> map){
            if(node == null) return;
            dfs(node.left, map);
            dfs(node.right, map);
            if(!map.containsKey(node.val)) map.put(node.val, 0);
            map.put(node.val, map.get(node.val) + 1);
            maxCount = Math.max(maxCount, map.get(node.val));
        }
    }



}
