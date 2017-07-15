package leetcode;

/**
 * Created by HuaZ on 7/15/2017.

 Given a binary array, find the maximum number of consecutive 1s in this array
 if you can flip at most one 0.

 Example 1:

 Input: [1,0,1,1,0]
 Output: 4
 Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 After flipping, the maximum number of consecutive 1s is 4.

 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000

 Follow up:
 What if the input numbers come in one by one as an infinite stream? In other words,
 you can't store all numbers coming from the stream as it's too large to hold in memory.
 Could you solve it efficiently?

 */
import java.util.*;
public class N487_MaxConsecutiveOnesII {
    // general solution to allow k zeros, sliding window
    // classic google question
    // 41 / 41 test cases passed.
    // 15 ms
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int ret = 0, zeros = 0, k = 1;
            for(int l=0, h =0; h<nums.length; h++){
                if(nums[h] == 0) zeros++;
                if(zeros > k){ // move window condition: move forward l and reduce number of zeros.
                    while(zeros > k){
                        if(nums[l++] == 0) zeros--;
                    }
                }
                ret = Math.max(ret, h -l + 1);
            }
            return ret;
        }
    }

    // follow up solution, use queue to store 0 positions
    // 41 / 41 test cases passed.
    // 22 ms
    public class Solution_followup {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0, k = 1; // flip at most k zero
            Queue<Integer> zeroIndex = new LinkedList<>();
            for (int l = 0, h = 0; h < nums.length; h++) {
                if (nums[h] == 0)
                    zeroIndex.offer(h);
                if (zeroIndex.size() > k)
                    l = zeroIndex.poll() + 1;
                max = Math.max(max, h - l + 1);
            }
            return max;
        }
    }
}
