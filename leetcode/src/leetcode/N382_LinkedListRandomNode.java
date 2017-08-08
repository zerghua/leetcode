package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Hua on 8/24/16.

 Given a singly linked list, return a random node's value from the linked list.
 Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you?
 Could you solve this efficiently without using extra space?
 https://en.wikipedia.org/wiki/Reservoir_sampling

 Example:

 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();


 */
public class N382_LinkedListRandomNode {
    // Google
    // 159 ms random.nextInt()
    public class Solution {
        private ArrayList<Integer> list;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            list = new ArrayList<>();
            while(head!=null) {
                list.add(head.val);
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random random = new Random();
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

    // Reservoir_sampling added on 10/27/2016, not tested
    // o(n) time, o(1) space
    public class Solution2 {
        private int count;
        Random rand;
        ListNode cur;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution2(ListNode head) {
            count = 0;
            rand = new Random();
            cur = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int ret=0;
            while(cur != null){
                if(rand.nextInt(++count) == 0) ret = cur.val;
                cur=cur.next;
            }
            return ret;
        }
    }
}
