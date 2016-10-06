package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by HuaZ on 7/23/2016.

 Given an array nums, there is a sliding window of size k
 which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window.
 Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 Hint:

 How about using a data structure such as deque (double-ended queue)?
 The queue size need not be the same as the window’s size.
 Remove redundant elements and the queue should store only elements
 that need to be considered.


 */
public class N239_SlidingWindowMaximum {
    // 30 ms
    // time o(n), space o(k), deque. pop smaller last element.
    // brute force, time o(k*n), space o(1)
    // maintain a descending deque as  [max, second max ... min]  with K elements.
    // remove first if out of K, always get max from the first.
    // similar to the min stack problem.
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k<=0) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        int ret_index = 0;
        Deque<Integer> deque = new ArrayDeque<>(); // store index of array
        for(int i=0; i<nums.length;i++){
            // remove the first if out of range k
            if(!deque.isEmpty() && deque.peek() < i+1-k){
                deque.removeFirst();
            }

            // pop last if less than coming in
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);
            if(i >= k-1){
                ret[ret_index++] = nums[deque.peek()];
            }
        }
        return ret;
    }
}
