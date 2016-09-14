package leetcode;
import leetcode.N0_data_strcture.*;
/*

 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 */
public class N141_LinkedListCycle {
	//1 ms
    // two pointers, fast and slow.
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
