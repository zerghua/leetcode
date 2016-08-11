package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 5/25/2016.

 Given a singly linked list, group all odd nodes together followed by the even nodes.
 Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity
 and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...

 */
public class N328_OddEvenLinkedList {
    //1 ms
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = head, even_head= head.next;
        boolean is_odd = true;
        while(cur.next!=null){
            ListNode next = cur.next;
            cur.next = next.next;
            pre = cur;
            cur = next;

            // flip flag
            if(is_odd) is_odd = false;
            else is_odd = true;
        }
        if(is_odd) cur.next = even_head;
        else pre.next = even_head;
        return head;
    }

    //or can use two pointers, one for odd, one for even.
}
