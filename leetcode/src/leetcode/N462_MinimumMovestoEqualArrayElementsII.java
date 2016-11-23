package leetcode;

import java.util.Arrays;

/**
 * Created by HuaZ on 11/23/2016.

 Given a non-empty integer array, find the minimum number of moves required to
 make all array elements equal, where a move is incrementing a selected element by 1 or
 decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]


 */
public class N462_MinimumMovestoEqualArrayElementsII {
    // time o(nlogn), can't prove why it's minimum moves.
    // math
    // 9 ms  29 / 29 test cases passed.
    public class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int i=0, j=nums.length-1, ret=0;
            while(i<j) ret += nums[j--] - nums[i++];
            return ret;
        }
    }
}
