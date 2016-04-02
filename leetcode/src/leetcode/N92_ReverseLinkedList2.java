package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 4/2/2016.
 */
public class N92_ReverseLinkedList2 {
    //0 ms
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre_start_node = dummy;

        while(m>1){
            m--;n--;
            pre_start_node=pre_start_node.next;
        }
        ListNode start_node = pre_start_node.next;

        ListNode pre=start_node, current =pre.next, next=null;
        while(n>1){
            n--;
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        pre_start_node.next = pre;
        start_node.next = current;

        return dummy.next;
    }
}
