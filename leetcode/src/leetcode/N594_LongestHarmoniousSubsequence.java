package leetcode;

/**
 * Created by Hua on 6/14/2017.

 We define a harmonious array is an array where the difference between its maximum value and
 its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence
 among all its possible subsequences.

 Example 1:

 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].

 Note: The length of the input array will not exceed 20,000.


 */
import java.util.*;
public class N594_LongestHarmoniousSubsequence {
    // LiveRamp
    // hashmap to check neighbour elements, no need to check both +1 and -1
    // 201 / 201 test cases passed.
    // 77 ms
    public class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int n : nums){
                if(!map.containsKey(n)) map.put(n, 1);
                else map.put(n, map.get(n)+1);
            }

            int ret = 0;
            for(int key : map.keySet()){
                if(map.containsKey(key+1)) ret = Math.max(ret, map.get(key) + map.get(key+1));
            }
            return ret;
        }
    }
}
