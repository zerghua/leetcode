package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2017.

 Given a non-empty array of non-negative integers nums, the degree of this array is defined
 as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 that has the same degree as nums.

 Example 1:

 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.

 Example 2:

 Input: [1,2,2,3,1,4,2]
 Output: 6

 Note:
 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.

 */
public class N697_DegreeofanArray {
    // my AC contest solution
    // map
    // 89 / 89 test cases passed.
    // 77 ms
    class Solution {
        class Node{
            int count, start, end;
            Node(){
                start= Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }

        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, Node> map = new HashMap();
            int max = 0;
            for(int i=0; i<nums.length; i++) {
                int e = nums[i];
                if (!map.containsKey(e)) map.put(e, new Node());
                map.get(e).count++;
                map.get(e).start = Math.min(i, map.get(e).start);
                map.get(e).end = Math.max(i, map.get(e).end);
                max = Math.max(max, map.get(e).count);
            }

            int ret = nums.length;
            for(int e : map.keySet()){
                if(map.get(e).count == max){
                    ret = Math.min(ret, map.get(e).end - map.get(e).start + 1);
                }
            }
            return ret;
        }
    }
}
