package leetcode;


// 308 ms, 75%
public class N237_deleteNode {
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }

}
