package leetcode;

/**
 * Created by Hua on 7/18/2017.

 Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?


 Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree.
 If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes,
 so just push the new one onto the stack. But before that, pop all smaller ancestor values, as we must now be in
 their right subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values
 as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.


 // tricky problem, one preorder sequence can not guarantee a fixed tree
for example:
 [5,4,3,6,7]  can be
      5                 5
    /  \              /  \
   4    7            4    6
  / \               /      \
 3  6              3        7
 invalid BST       valid BST


 */
import java.util.*;
public class N255_VerifyPreorderSequenceinBinarySearchTree {
    // zenefits (Premium)
    // stack and tricky
    // 61 / 61 test cases passed.
    // 35 ms
    public class Solution {
        public boolean verifyPreorder(int[] preorder) {
            int min = Integer.MIN_VALUE;
            Stack<Integer> stack = new Stack();
            for(int num : preorder){
                if(num < min) return false;
                while(!stack.isEmpty() && num > stack.peek()) min = stack.pop();
                stack.push(num);
            }
            return true;
        }
    }


    // o(1) space
    // 61 / 61 test cases passed.
    // 4 ms
    public class Solution2 {
        public boolean verifyPreorder(int[] preorder) {
            int low = Integer.MIN_VALUE, i = -1;
            for (int p : preorder) {
                if (p < low) return false;
                while (i >= 0 && p > preorder[i]) low = preorder[i--];
                preorder[++i] = p;
            }
            return true;
        }
    }

}
