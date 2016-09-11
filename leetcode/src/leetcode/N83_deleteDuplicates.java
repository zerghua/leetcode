package leetcode;
import leetcode.N0_data_strcture.*;

/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */

public class N83_deleteDuplicates {
	// 316 ms  83%
    // linked list skip next one if equals.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next!=null){
        	if(cur.val == cur.next.val) cur.next = cur.next.next;
        	else cur=cur.next;
        }
        return head;
    }
}
