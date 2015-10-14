package leetcode;
import leetcode.N0_data_strcture.*;

/*
//The key to solve this problem is using a helper node to track the head of the list.
public ListNode removeElements(ListNode head, int val) {
    ListNode helper = new ListNode(0);
    helper.next = head;
    ListNode p = helper;
 
    while(p.next != null){
        if(p.next.val == val){
            ListNode next = p.next;
            p.next = next.next; 
        }else{
            p = p.next;
        }
    }
 
    return helper.next;
}
 */

public class N203_RemoveLinkedListElements {
	// 1 ms
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val) head = head.next;
        if(head == null) return null;
        
        ListNode cur = head;
        while(cur.next != null){
        	if(cur.next.val == val) cur.next = cur.next.next;
        	else cur = cur.next;
        }
        
        return head;
    }
}
