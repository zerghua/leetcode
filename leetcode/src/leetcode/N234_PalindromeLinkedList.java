package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

public class N234_PalindromeLinkedList {
	//7 ms
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
