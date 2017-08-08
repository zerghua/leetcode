package leetcode;
import java.util.*;
import leetcode.N0_data_strcture.*;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class N160_IntersectionofTwoLinkedLists {
	// Amazon, Microsoft
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
