package leetcode;

/**
 * Created by Hua on 7/20/2017.

 Given a binary tree, return the vertical order traversal of its nodes' values.
 (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],

    3
   /\
  /  \
 9   20
     /\
    /  \
   15   7

 return its vertical order traversal as:

 [
     [9],
     [3,15],
     [20],
     [7]
 ]

 Given binary tree [3,9,8,4,0,1,7],

         3
        /\
       /  \
      9    8
     /\   /\
    /   \/  \
   4   01   7

 return its vertical order traversal as:

 [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
 ]

 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),

       3
      /\
     /  \
    9   8
    /\  /\
   /  \/  \
  4  01   7
     /\
    /  \
   5   2

 return its vertical order traversal as:

 [
     [4],
     [9,5],
     [3,0,1],
     [8,2],
     [7]
 ]


 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N314_BinaryTreeVerticalOrderTraversal {
    // Google, Facebook
    public class Solution {
        class Node{
            TreeNode node;
            int index;
            Node(TreeNode node, int index){
                this.node = node;
                this.index = index;
            }
        }

        // level-order traversal with a little trick to track column index
        // 212 / 212 test cases passed.
        // 4 ms
        public List<List<Integer>> verticalOrder(TreeNode root) {
            int min_index = 0;
            List<List<Integer>> ret = new LinkedList();
            if(root == null) return ret;
            LinkedList<Node> q = new LinkedList();
            q.add(new Node(root, 0));

            while(!q.isEmpty()){
                Node node = q.removeFirst();
                if(node.index < min_index) {
                    ret.add(0, new LinkedList());
                    min_index = node.index;
                }
                else if(node.index - min_index >= ret.size()) ret.add(new LinkedList());

                ret.get(node.index - min_index).add(node.node.val);
                if(node.node.left != null) q.add(new Node(node.node.left, node.index - 1));
                if(node.node.right != null) q.add(new Node(node.node.right, node.index + 1));
            }
            return ret;
        }
    }
}
