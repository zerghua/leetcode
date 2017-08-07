package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 4/5/2016.

 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.


 */
public class N82_RemoveDuplicatesfromSortedList2 {
    // no company
    //1 ms
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next = cur.next;
        boolean should_remove_cur = false;
        while(next.next != null){
            if(next.val == next.next.val) {
                should_remove_cur=true;
                cur.next = next.next;
                next = cur.next;
            }
            else{
                if(should_remove_cur) {
                    should_remove_cur=false;
                    cur.next = next.next;
                    next = cur.next;
                }else  {
                    cur = cur.next;
                    next = cur.next;
                }
            }
        }
        if(should_remove_cur) {
            cur.next = next.next;
        }

        return dummy.next;
    }

    //cur is unique, remove all the dup after cur, and then advance cur
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int dup_val = cur.next.val;
                //skip cur next
                while(cur.next !=null && cur.next.val == dup_val){
                    cur.next = cur.next.next;
                }

            }else cur = cur.next;
        }

        return dummy.next;
    }

}
