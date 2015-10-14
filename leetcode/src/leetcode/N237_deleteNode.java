package leetcode;
import leetcode.N0_data_strcture.*;

// 308 ms, 75%
public class N237_deleteNode {
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }

}
