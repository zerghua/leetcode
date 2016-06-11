package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Hua on 6/11/2016.
 *
 Sort a linked list in O(n log n) time using constant space complexity.

 */
public class N148_SortList {
    //Memory limit exceed.
    public ListNode sortList2(ListNode head) {
        if(head == null) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        for(ListNode node: list){
            dummy.next = node;
            dummy = dummy.next;
        }
        return list.get(0);
    }


    // 8ms
    // merge sort
    public ListNode sortList(ListNode head) {
        if(head ==null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next; //important
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p2 = sortList(slow.next);
        slow.next = null;
        ListNode p1 = sortList(head);
        return merge(p1, p2);
    }

    public ListNode merge(ListNode p1, ListNode p2){
        ListNode dummy= new ListNode(0), p=dummy;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = (p1==null)?p2:p1;
        return dummy.next;
    }

}
