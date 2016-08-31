package leetcode;
import leetcode.N0_data_strcture.*;
/**
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class N24_SwapNodesinPairs {
    //0 ms, modified value
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next!=null){
            int tmp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = tmp;
            cur = cur.next.next;
        }
        return head;
    }

    // below comment added on 8/31/2016
    //  pre -->  cur --> next  --> next.next
    //  1.  pre/cur --> next --> next.next
    //  2.  pre --> next    cur --> next.next
    //  3.  pre --> next --> cur --> next.next
    //  key is to use dummy node and operate on THREE links.

    //0 ms
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        while(cur != null && cur.next!=null){
            ListNode nextNode = cur.next;
            pre.next = nextNode;        // 1. pre   --->  next       (pre points its next'next)
            cur.next = nextNode.next;   // 2. cur   --->  next.next  (cur points its next'next)
            nextNode.next = cur;        // 3. next  --->  cur        (next points to cur) swap
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


}
