package leetcode;
import java.util.*;
import leetcode.N0_data_strcture.*;

public class N160_IntersectionofTwoLinkedLists {
	public int get_ListNode_length(ListNode node){
		int len = 0;
		while(node != null){
			len++;
			node=node.next;
		}	
		return len;
		
	}
	//3 ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int a_length=get_ListNode_length(headA); 
    	int b_length=get_ListNode_length(headB); 
    	
    	if(a_length>b_length){
    		int diff_steps = a_length - b_length;
    		while(diff_steps>0){
    			headA = headA.next;
    			diff_steps--;
    		}
    	}else{
    		int diff_steps = b_length - a_length;
    		while(diff_steps>0){
    			headB = headB.next;
    			diff_steps--;
    		}    			
    	}
    	
    	while(headA != null && headB !=null){
    		if(headA.val == headB.val) return headA;	
    		headA=headA.next;
    		headB=headB.next;
    	}
    	return null;	
    }
}
