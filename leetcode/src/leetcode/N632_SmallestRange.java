package leetcode;

/**
 * Created by Hua on 7/6/2017.

 You have k lists of sorted integers in ascending order. Find the smallest range that includes
 at least one number from each of the k lists.

 We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 Example 1:

 Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 Output: [20,24]
 Explanation:
 List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 List 2: [0, 9, 12, 20], 20 is in range [20,24].
 List 3: [5, 18, 22, 30], 22 is in range [20,24].

 Note:

 The given list may contain duplicates, so ascending order means >= here.
 1 <= k <= 3500
 -10^5 <= value of elements <= 10^5.
 For Java users, please note that the input type has been changed to List<List<Integer>>.
 And after you reset the code template, you'll see this point.

 */

import java.util.*;
public class N632_SmallestRange {
    // Lyft
    // heap + smart coding.
    // 86 / 86 test cases passed.
    // 135 ms
    public class Solution {
        public class Node{
            int val;
            int row, index;
            Node(int val, int row, int index){
                this.val = val;
                this.row = row;
                this.index = index;
            }
        }
        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Node> heap = new PriorityQueue<Node>((a,  b) -> a.val - b.val);
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for(int i=0; i<nums.size(); i++){
                heap.add(new Node(nums.get(i).get(0), i, 0));
                max = Math.max(max, nums.get(i).get(0));
            }

            int start = -1, end = -1, range = Integer.MAX_VALUE;
            while(heap.size() == nums.size()){  // very smart code
                Node node = heap.poll();
                if(max - node.val < range){
                    start = node.val;
                    end = max;
                    range = max - node.val;
                }

                if(node.index + 1 < nums.get(node.row).size()){
                    node.index++;
                    node.val = nums.get(node.row).get(node.index);
                    max = Math.max(max, node.val);
                    heap.add(node);
                }
            }
            return new int[]{start, end};
        }
    }
}
