package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 4/10/2016.

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 */
public class N61_RotateList {
    // no company
    //1 ms
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int list_size=1;
        ListNode tail = head;
        while(tail.next!=null){
            list_size++;
            tail = tail.next;
        }

        k = k % list_size;
        if(k==0) return head;

        int last_node_index = list_size-k-1;
        ListNode last_node =head;
        for(int i=0; i<= last_node_index; i++){
            last_node = last_node.next;
        }

        ListNode new_head = last_node.next;
        last_node.next = null;
        tail.next = head;
        return new_head;
    }

    //less code version  1ms
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null) return head;

        int list_size=1;
        ListNode tail = head;
        while(tail.next!=null){
            list_size++;
            tail = tail.next;
        }

        tail.next = head; // cycled list
        int steps = list_size - k%list_size;
        while(steps > 0){
            tail = tail.next;
            steps--;
        }

        head = tail.next;
        tail.next = null;
        return head;
    }

}
