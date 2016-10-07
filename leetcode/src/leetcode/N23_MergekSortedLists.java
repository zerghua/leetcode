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

    // added on 10/5/2016, improved the way heap is initialized.
    // 24 ms  130 / 130 test cases passed.
    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;

            // min heap, natural ordering by val in ListNode
            Queue<ListNode> heap = new PriorityQueue<ListNode>((o1,o2)-> o1.val - o2.val);

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

    // added on 10/7/2016
    // o(1) space solution, divide and conquer.
    // 13 ms 130 / 130 test cases passed.
    public class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            int end=lists.length-1;
            while(end>0){
                int begin = 0;
                while(begin < end){
                    lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                    begin++;
                    end--;
                }
            }
            return lists[0];
        }

        // reusing solution from N21 merge two sorted list
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
}

