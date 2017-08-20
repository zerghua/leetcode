package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

(1) Move: fast pointer goes to the end, and slow goes to the middle.
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
(3) Compare: run the two pointers head and slow together and compare.


 */

public class N234_PalindromeLinkedList {
	// Amazon, Facebook
    // o(n) time, o(n) space
	// 7 ms
    public boolean isPalindrome(ListNode head) {
    	if(head == null) return true;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	while(head !=null ){
    		al.add(head.val);
    		head=head.next;
    	}  
    	int i=0, j=al.size()-1;
    	while(i<j){
    		if(!al.get(i).equals(al.get(j))) return false;	
    		i++;j--;
    	}
    	return true;
    }
}
