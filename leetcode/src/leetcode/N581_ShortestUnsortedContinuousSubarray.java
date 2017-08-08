package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 6/14/2017.

 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending
 order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:

 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

 Note:

 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 */
public class N581_ShortestUnsortedContinuousSubarray {
    // Google, LiveRamp
    // o(nlogn) sort and compare, easy
    // 307 / 307 test cases passed.
    // 44 ms
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] tmp = new int[nums.length];
            System.arraycopy(nums, 0, tmp, 0, nums.length);
            Arrays.sort(tmp);

            int start = 0, end = nums.length-1;
            while(start < nums.length && nums[start] == tmp[start]) start++;
            while(end > start && nums[end] == tmp[end]) end--;

            return end - start + 1;
        }
    }

    // o(n), medium
    // 307 / 307 test cases passed.
    // 22 ms
    public class Solution2 {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length, end = -1, start = 0, max = nums[0], min = nums[n-1];
            for(int i=1; i< n; i++){
                max = Math.max(max, nums[i]);
                if(nums[i] < max) end = i;

                min = Math.min(min, nums[n-1-i]);
                if(nums[n-1-i] > min) start = n-1-i;
            }
            return end - start + 1;
        }
    }
}
