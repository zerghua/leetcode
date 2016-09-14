package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 4/11/2016.

 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 */
public class N143_ReorderList {
    // find mid point
    // reverse second half list
    // merge two list

    //3 ms
    public void reorderList(ListNode head) {
        ListNode right_end = reverseList(findMidPoint(head));
        mergeList(head, right_end);
    }

    public void mergeList(ListNode left, ListNode right){
        ListNode cur = left;
        while(right!=null && right.next != null) {
            ListNode tmp = right.next;
            right.next = cur.next;
            cur.next = right;
            cur = cur.next.next;
            right = tmp;
        }
    }

    public ListNode findMidPoint(ListNode head){
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null, cur = head, next=cur;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
