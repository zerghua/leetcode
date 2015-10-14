package leetcode;

import leetcode.N0_data_strcture.*;

public class N83_deleteDuplicates {
	// 316 ms  83%
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next!=null){
        	if(cur.val == cur.next.val) cur.next = cur.next.next;
        	else cur=cur.next;
        }
        return head;
    }
}
