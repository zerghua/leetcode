package leetcode;

/**
 * Created by Hua on 8/11/2017.

 You are given an array of positive and negative integers.
 If a number n at an index is positive, then move forward n steps.
 Conversely, if it's negative (-n), move backward n steps.
 Assume the first element of the array is forward next to the last element,
 and the last element is backward next to the first element.
 Determine if there is a loop in this array.
 A loop starts and ends at a particular index with more than 1 element along the loop.

 The loop must be "forward" or "backward'.(This is important)

 Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

 Example 2: Given the array [-1, 2], there is no loop.

 Note: The given array is guaranteed to contain no element "0".

 Can you do it in O(n) time complexity and O(1) space complexity?


 Test cases:
 Input:[-2, 1, -1, -2, -2]
 Expected:false

 Input:[2, -1, 1, -2, -2]
 Expected:false

 Input:[3,1,2]
 Expected:true

 I guess the reason is that the initial position is not necessarily the zeroth element.
 For {3, 1, 2}, if we count from 1, then there is a cycle 1 -> 2 -> 1 with more than one element, which is valid.
 For {-1, -2, -3, -4, -5}, no matter what position we start from, we always end up with a cycle -5 -> -5,
 which includes only one element and is thus invalid.

 */
public class N457_CircularArrayLoop {
    // kind of DFS
    // 10 / 10 test cases passed.
    // 1 ms
    public class Solution {
        public boolean circularArrayLoop(int[] nums) {
            if(nums == null || nums.length == 0) return false;
            int pre = 0, cur = 0, n = nums.length;

            for(int i=0 ; i<n ; i++){
                if(nums[i] == 0) continue;

                pre = cur = i;
                int sign = nums[cur] > 0 ? 1 : -1;
                boolean isReversed  = false;

                while(nums[cur] != 0){
                    pre = cur;
                    cur += nums[cur];
                    if(nums[pre] * sign < 0) {
                        isReversed = true;
                        break;
                    }
                    nums[pre] = 0;
                    if(cur >= n) cur -= n;
                    if(cur < 0) cur += n;
                }

                if(pre != cur && !isReversed && i == cur) return true;
            }
            return false;
        }
    }
}
