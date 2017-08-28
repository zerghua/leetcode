package leetcode;

import java.util.HashSet;

/**
 * Created by HuaZ on 11/25/2016.

 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.

 https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/7


 to iteratively determine what would be each bit of the final result from left to right.
 And it narrows down the candidate group iteration by iteration.
 e.g. assume input are a,b,c,d,...z, 26 integers in total.
 In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit),
 so you are sure your final result's MSB is set. Now in second iteration,
 you try to see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs,
 if yes, then definitely, the 2nd MSB will be set in the final result.
 And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h.
 Implicitly, every iteration, you are narrowing down the candidate group,
 but you don't need to track how the group is shrinking, you only cares about the final result.

 */
public class N421_MaximumXORofTwoNumbersinanArray {
    // Google
    // bit manipulation
    // require o(n) solution,
    // BF is o(n^2) solution
    // 101 ms 29 / 29 test cases passed.
    // need to think more how this works
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int max=0, mask=0;
            for(int i=31;i>=0;i--){
                mask |= (1<<i);
                HashSet<Integer> set = new HashSet();
                for(int num: nums) set.add(mask & num); // reserve Left bits and ignore Right bits

                // if a^b=c, then a^c=b, b^c=a
                int tmp = max | (1<<i);   // in each iteration, there are pair(s) whose Left bits can XOR to max
                for(int prefix: set){
                    if(set.contains(tmp^prefix)) {
                        max = tmp;
                        break;
                    }
                }
            }
            return max;
        }
    }
}
