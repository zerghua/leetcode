package leetcode;

import java.util.Stack;

/**
 * Created by HuaZ on 11/18/2016.

 Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 Design an algorithm that takes a list of n numbers as input and checks
 whether there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:

 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.

 Example 2:

 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

 Example 3:

 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 https://discuss.leetcode.com/topic/67881/single-pass-c-o-n-space-and-time-solution-8-lines-with-detailed-explanation/2

 */
public class N456_132Pattern {
    // wrong result, only works for ak > ai and ak > aj,
    // but the problem requires ai < ak < aj
    public class Solution {
        public boolean find132pattern(int[] nums) {

            boolean[] isPeak = new boolean[nums.length];
            int min = nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i] > min) isPeak[i] = true;
                min = Math.min(min, nums[i]);
            }

            min = nums[nums.length-1];
            for(int i=nums.length-2; i>=0; i--){
                if(nums[i] > min && isPeak[i]) return true;
                min = Math.min(min, nums[i]);
            }
            return false;
        }
    }


    // stack solution
    // require one < three < two
    // 28 ms 87 / 87 test cases passed.
    public class Solution2 {
        public boolean find132pattern(int[] nums) {
            if(nums ==null || nums.length <3) return false;
            Stack<Integer> stack = new Stack();
            for(int three = Integer.MIN_VALUE, i=nums.length-1;i>=0;i--){
                if(nums[i] < three) return true;
                else while(!stack.isEmpty() && nums[i] > stack.peek()){
                    three = stack.pop();
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }
}
