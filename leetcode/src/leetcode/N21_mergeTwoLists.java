package leetcode;
import leetcode.N0_data_strcture.*;

public class N21_mergeTwoLists {
	//280 ms 99%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakeHead = new ListNode(0);
		ListNode p = fakeHead;
		while(l1 !=null && l2!=null){
			if(l1.val < l2.val){
				p.next = l1;
				l1 = l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			p=p.next;
		}
		
		if(l1!=null) p.next =l1;
		if(l2!=null) p.next =l2;
        return fakeHead.next;
    }
}
