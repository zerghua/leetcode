package leetcode;

/**
 * Created by Hua on 5/19/2017.

 You are given two non-empty linked lists representing two non-negative integers.
 The most significant digit comes first and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7

 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N445_AddTwoNumbersII {
    // Microsoft, Bloomberg
    // stack + linked list
    // 1563 / 1563 test cases passed.
    // 64 ms
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack();
            Stack<Integer> s2 = new Stack();
            while(l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }

            while(l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }

            ListNode root = new ListNode(0);
            int sum = 0;
            while(!s1.isEmpty() || !s2.isEmpty()){
                if(!s1.isEmpty()) sum += s1.pop();
                if(!s2.isEmpty()) sum += s2.pop();

                root.val = sum % 10;
                sum /= 10;

                ListNode newRoot = new ListNode(sum);
                newRoot.next = root;
                root = newRoot;
            }

            return root.val == 0 ? root.next : root;
        }
    }
}
