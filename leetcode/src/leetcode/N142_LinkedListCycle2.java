package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 6/1/2016.

 Given a linked list, return the node where the cycle begins.
 If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?

 */
public class N142_LinkedListCycle2 {
    // no company
    // 1 ms
    // reset slow to head, one step of each, they will meet at the start.
    // if fast and slow start from the same point, they will meet at start
    // if fast has a head start of k, they will meet at n-k
    // reset slow to n-k which is the head of list, and move one by one,
    // will guarantee meet at the start.
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode fast = head, slow = head;
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        // no cycle
        if(fast == null || fast.next == null) return null;

        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
