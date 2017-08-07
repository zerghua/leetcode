package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/25/2016.

 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 */


public class N109_ConvertSortedListtoBinarySearchTree {
    // Zenefits
    // 10/8/2016
    // 32 / 32 test cases passed.
    // 1 ms
    public class Solution {
        private ListNode node ;

        public TreeNode buildBST(int start, int end){
            if(start > end) return null;

            int mid = (end-start)/2 + start;
            TreeNode left = buildBST(start, mid-1);
            TreeNode root = new TreeNode(node.val);
            node = node.next;
            TreeNode right = buildBST(mid+1, end);
            root.left = left;
            root.right = right;
            return root;
        }

        public TreeNode sortedListToBST(ListNode head) {
            node = head;

            //get length of ListNode
            int len = 0;
            while(head != null){
                len++;
                head=head.next;
            }

            // build tree
            return buildBST(0, len-1);
        }
    }
}
