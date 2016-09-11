package leetcode;
import leetcode.N0_data_strcture.*;
/*
Reverse a singly linked list.

click to show more hints.
Hint:

A linked list can be reversed either iteratively or recursively. Could you implement both?


 */

public class N206_reverseList {
	//308 ms 44%
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
    
    //264 ms  94%
    public ListNode reverseList2(ListNode head) {
    	ListNode next=null, current =null;
    	while(head != null){
    		next = head.next;
    		head.next = current;
			current = head;
    		head = next;
    	}
    	return current;
    }    
    
    
}
