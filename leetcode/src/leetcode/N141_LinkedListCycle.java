package leetcode;
import leetcode.N0_data_strcture.*;

public class N141_LinkedListCycle {
	//1 ms
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow) return true;
        }
    	return false;
    }
}
