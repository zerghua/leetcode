package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/26/2016.
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
}
