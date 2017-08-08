package leetcode;

import java.util.Stack;

/**
 * Created by Hua on 5/15/2017.

 Given a circular array (the next element of the last element is the first element of the array), print
 the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to
 its traversing-order next in the array, which means you could search circularly to find its next greater number.
 If it doesn't exist, output -1 for this number.

 Example 1:

 Input: [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number;
 The second 1's next greater number needs to search circularly, which is also 2.

 Note: The length of given array won't exceed 10000.

 */



public class N503_NextGreaterElement2 {
    // Google
    // stack tricky solution, needs some proof from math side.
    // the lower element in stack is bigger than the upper one.
    // The second way is to use a stack to facilitate the look up. First we put all indexes into the stack,
    // smaller index on the top. Then we start from end of the array look for the first element (index) in the stack
    // which is greater than the current one. That one is guaranteed to be the Next Greater Element. Then put
    // the current element (index) into the stack. Time complexity: O(n).

    // The first typical way to solve circular array problems is to extend the original array to twice length,
    // 2nd half has the same element as first half. Then everything become simple.
    // Naive by simple solution, just look for the next greater element directly. Time complexity: O(n^2).

    // 224 / 224 test cases passed.
    // 63 ms
    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Stack<Integer> stack = new Stack();
            for(int i=n-1; i>=0; i--) stack.add(i);

            for(int i=n-1; i>=0; i--){
                ret[i] = -1;
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();

                if(!stack.isEmpty()) ret[i] = nums[stack.peek()];
                stack.add(i);
            }
            return ret;
        }
    }

}
