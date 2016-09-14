package leetcode;
import leetcode.N0_data_strcture.*;

/**
 * Created by Hua on 3/26/2016.

 Sort a linked list using insertion sort.

 */
public class N147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur.next != null) {
            ListNode startNode = dummy;
            ListNode toInsertNode= cur.next;
            Boolean isInserted=false;
            while(startNode != cur){
                if(toInsertNode.val <= startNode.next.val){
                    cur.next=toInsertNode.next;
                    toInsertNode.next = startNode.next;
                    startNode.next = toInsertNode;
                    isInserted=true;
                    break;
                }
                startNode=startNode.next;
            }
            if(!isInserted)cur=cur.next;
        }

        return dummy.next;
    }
}
