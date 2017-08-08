package leetcode;

import java.util.HashSet;

/**
 * Created by HuaZ on 11/25/2016.

 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.

 https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/7

 */
public class N421_MaximumXORofTwoNumbersinanArray {
    // Google
    // bit manipulation
    // require o(n) solution,
    // BF is o(n^2) solution
    public class Solution {
        // 101 ms 29 / 29 test cases passed.
        // need to think more how this works
        public int findMaximumXOR(int[] nums) {
            int max=0, mask=0;
            for(int i=31;i>=0;i--){
                mask |= (1<<i);
                HashSet<Integer> set = new HashSet();
                for(int num: nums) set.add(mask & num); // retain left 1 bits

                int tmp = max | (1<<i);
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
