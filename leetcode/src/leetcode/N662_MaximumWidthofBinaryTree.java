package leetcode;

/**
 * Created by Hua on 8/21/2017.


 Given a binary tree, write a function to get the maximum width of the given tree.
 The width of a tree is the maximum width among all levels.
 The binary tree has the same structure as a full binary tree, but some nodes are null.

 The width of one level is defined as the length between the end-nodes
 (the leftmost and right most non-null nodes in the level,
 where the null nodes between the end-nodes are also counted into the length calculation.

 Example 1:

 Input:

      1
    /   \
   3     2
  / \     \
 5   3     9

 Output: 4
 Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

 Example 2:

 Input:

     1
    /
   3
  / \
 5   3

 Output: 2
 Explanation: The maximum width existing in the third level with the length 2 (5,3).

 Example 3:

 Input:

     1
    / \
   3   2
  /
 5

 Output: 2
 Explanation: The maximum width existing in the second level with the length 2 (3,2).

 Example 4:

 Input:

       1
      / \
     3   2
    /     \
   5       9
  /         \
 6           7
 Output: 8
 Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


 Note: Answer will in the range of 32-bit signed integer.


 */
import leetcode.N0_data_strcture.*;
import java.util.*;

public class N662_MaximumWidthofBinaryTree {
    // BFS with a trick of left child index is 2*cur_index-1, right child is 2*cur_index
    // 108 / 108 test cases passed.
    // 11 ms
    class Solution {
        class Node{
            TreeNode node;
            int count;
            Node(TreeNode node, int count){
                this.node = node;
                this.count = count;
            }
        }
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null) return 0;
            LinkedList<Node> list = new LinkedList();
            int ret = 1;
            list.add(new Node(root, 1));
            while(!list.isEmpty()){
                int size = list.size();
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for(int i=0; i<size; i++){
                    Node node = list.removeFirst();
                    min = Math.min(min, node.count);
                    max = Math.max(max, node.count);
                    if(node.node.left !=null) list.add(new Node(node.node.left, node.count*2-1));
                    if(node.node.right !=null) list.add(new Node(node.node.right, node.count*2));
                }
                ret = Math.max(ret, max - min + 1);
            }
            return ret;
        }
    }
}
