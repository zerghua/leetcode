package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 5/7/2017.

 Given an array of integers and an integer k, you need to find the number of unique k-diff pairs
 in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both
 numbers in the array and their absolute difference is k.

 Example 1:

 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.

 Example 2:

 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

 Example 3:

 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).

 Note:

 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].


 */
public class N532_KdiffPairsinanArray {
    // hash table, interesting solution.
    // 72 / 72 test cases passed.
    // 35 ms
    public class Solution {
        public int findPairs(int[] nums, int k) {
            if(k < 0) return 0;

            HashMap<Integer, Integer> map = new HashMap();
            for(int i: nums){
                if(!map.containsKey(i)) map.put(i, 0);
                map.put(i, map.get(i)+1);
            }

            int ret = 0;
            if(k == 0) {
                for(int key : map.keySet()){
                    if(map.get(key) > 1) ret++;
                }
                return ret;
            }

            // when k is NOT 0
            for(int key : map.keySet()){
                if(map.containsKey(key + k)) ret++;
            }
            return ret;
        }
    }
}
