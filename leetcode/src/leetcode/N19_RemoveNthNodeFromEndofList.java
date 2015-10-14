package leetcode;
import leetcode.N0_data_strcture.*;

public class N19_RemoveNthNodeFromEndofList {
	//1 ms
    public ListNode removeNthFromEnd(ListNode head, int n) {    
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
}
