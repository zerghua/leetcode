package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Given a non-negative integer represented as non-empty a singly linked list of digits,
 plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 Input:
 1->2->3

 Output:
 1->2->4



 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N369_PlusOneLinkedList {
    // 108 / 108 test cases passed.
    // 2 ms
    // stack + linkedlist
    public class Solution {
        public ListNode plusOne(ListNode head) {
            Stack<ListNode> stack = new Stack();
            ListNode cur = head;
            while(cur != null){
                stack.add(cur);
                cur = cur.next;
            }

            int carry = 1;
            while(!stack.isEmpty()){
                ListNode node = stack.pop();
                if(node.val + carry == 10){
                    node.val = 0;
                    carry = 1;
                }else {
                    node.val = node.val + carry;
                    carry = 0;
                }
            }
            if(carry == 1) {
                ListNode new_head = new ListNode(1);
                new_head.next = head;
                return new_head;
            }
            return head;
        }
    }
}
