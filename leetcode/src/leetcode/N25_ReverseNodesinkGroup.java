package leetcode;
import leetcode.N0_data_strcture.*;
/**
 * Created by Hua on 4/22/2016.
 *
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class N25_ReverseNodesinkGroup {
    //1 ms
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur != null){
            int group =0;
            ListNode pre = cur;
            while(group < k && cur!=null){
                cur=cur.next;
                group++;
            }
            if(cur == null) break;
            cur = reverseList(pre, cur);
        }

        return dummy.next;
    }

    public ListNode reverseList(ListNode pre_start, ListNode end){
        ListNode ret = pre_start.next;
        ListNode cur = pre_start.next;
        ListNode pre = end.next;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        pre_start.next = cur;
        cur.next = pre;
        return ret;
    }


}
