package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 4/2/2016.

 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 */
public class N92_ReverseLinkedList2 {
    // no company
    //0 ms
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre_start_node = dummy;

        while(m>1){
            m--;n--;
            pre_start_node=pre_start_node.next;
        }
        ListNode start_node = pre_start_node.next;

        ListNode pre=start_node, current =pre.next, next=null;
        while(n>1){
            n--;
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        pre_start_node.next = pre;
        start_node.next = current;

        return dummy.next;
    }

    // more meaningful naming added on 9/11/2016
    // dummy node to solve first node issue
    // need extra preM, m_node to link head and tail. pre, cur, next for reversing node.
    // 0 ms  44 / 44 test cases passed.
    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre_m_node = dummy;
            while(m>1){
                m--;n--;
                pre_m_node = pre_m_node.next;
            }

            ListNode m_node = pre_m_node.next;
            ListNode pre = m_node, cur = m_node.next, next = null;
            while(n>1){
                n--;
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            pre_m_node.next = pre;
            m_node.next = cur;

            return dummy.next;
        }
    }
}
