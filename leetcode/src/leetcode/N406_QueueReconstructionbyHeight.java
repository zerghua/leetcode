package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/25/2016.

 Suppose you have a random list of people standing in a queue.
 Each person is described by a pair of integers (h, k),
 where h is the height of the person and k is the number of
 people in front of this person who have a height greater than
 or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution/3

 */
public class N406_QueueReconstructionbyHeight {
    // sort + insertion. kind of insertion sort.
    // 82 ms 37 / 37 test cases passed.
    // time o(nlogn) bounded by sort. insertion is o(1) for n times.
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a,b) -> a[0] == b[0]? a[1]-b[1] : b[0]-a[0]);// sort height reversely, and rank
            List<int[]> ret = new LinkedList();
            for(int[] p : people){
                ret.add(p[1], p);//insert people to its position by rank
            }
            return ret.toArray(new int[people.length][]);
        }
    }
}
