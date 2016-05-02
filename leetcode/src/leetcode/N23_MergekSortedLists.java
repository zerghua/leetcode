package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;

/**
 * Created by Hua on 5/2/2016.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class N23_MergekSortedLists {
    // 9 ms
    // custom PriorityQueue(heap)
    // time o(NlogK), space K, K is the size of lists
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        // min heap, natural ordering by val in ListNode
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                lists.length,
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        return a.val - b.val;
                    }
                }
        );

        //put initial k into heap
        for(ListNode e: lists){
            if(e != null) heap.add(e);
        }

        // remove and add next of removed
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!heap.isEmpty()){
            ListNode tmp = heap.poll();
            cur.next = tmp;
            if(tmp.next !=null) heap.add(tmp.next);
            cur = cur.next;
        }
        return dummy.next;
    }
}

