package leetcode;
import leetcode.N0_data_strcture.*;
/*

 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
the linked list should become 1 -> 2 -> 4 after calling your function.

 */

public class N237_deleteNode {
    // Apple, Microsoft
    // 308 ms, 75%
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }

}
