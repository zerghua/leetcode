package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/26/2016.
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 */
public class N86_PartitionList {

    // two pointers
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // move pre to the previous position of node larger than x
        while(pre.next !=null && pre.next.val<x) pre=pre.next;

        ListNode cur = pre;
        while(cur.next != null ) {
            if(cur.next.val < x){ // move to pre
                ListNode lessNode= cur.next;
                cur.next = lessNode.next;
                lessNode.next = pre.next;
                pre.next= lessNode;
                pre=pre.next;
            }else cur=cur.next;
        }

        return dummy.next;
    }


    // version 2 added on 9/11/2016
    // two dummy node and two pointers, dummy node points to the start of list, p is the current
    // pointer, will ended up point to the end of list.
    // 1 ms  166 / 166 test cases passed.
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(0);
            ListNode dummy2 = new ListNode(0);
            ListNode p1 = dummy1, p2 = dummy2;
            while(head != null) {
                if(head.val < x){
                    p1.next = head;
                    p1 = p1.next;
                }else{
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p1.next = dummy2.next;
            p2.next = null;
            return dummy1.next;
        }
    }
}
