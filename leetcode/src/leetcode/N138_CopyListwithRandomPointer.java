package leetcode;

/**
 * Created by Hua on 4/27/2016.

 A linked list is given such that each node contains an additional random pointer
 which could point to any node in the list or null.

 Return a deep copy of the list.

 */
public class N138_CopyListwithRandomPointer {
    public class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }

    //2 ms
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        // make copy of list and link them, as A->A1->B->B1
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode cur_next = cur.next;
            cur.next = newNode;
            newNode.next = cur_next;
            cur = cur_next;
        }

        // make new node's random point to new copy's random
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next; //important, new node's random
            }else cur.next.random = null;
            cur = cur.next.next;
        }

        //separate two list
        RandomListNode new_head = head.next;
        cur = head;
        while(cur !=null && cur.next != null){
            RandomListNode cur_next = cur.next;
            cur.next = cur_next.next;
            cur = cur_next;
        }
        return new_head;
    }
}
