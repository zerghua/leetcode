package leetcode;
import leetcode.N0_data_strcture.*;

/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.


 */
public class N19_RemoveNthNodeFromEndofList {
	// no company
	//1 ms
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n<=0) throw new IllegalArgumentException("n<=0");

    	ListNode cur = head;
    	for(int i=0;i<n;i++) cur = cur.next;
    	
    	//2 cases
    	if(cur == null) return head.next;
    	else{
	    	ListNode t=head;
	    	while(cur.next != null){
	    		t=t.next;
	    		cur=cur.next;
	    	}
	    	// remove t.next
	    	t.next = t.next.next;
	    	return head;
    	}
    }

    public static void main(String[] args){
        N19_RemoveNthNodeFromEndofList x = new N19_RemoveNthNodeFromEndofList();
        x.removeNthFromEnd(null, 0);
    }
}
