package leetcode;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
 the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 */
public class N53_MaximumSubarray {
    //1 ms
    public int maxSubArray(int[] nums) {
        int ret=Integer.MIN_VALUE, local_max=0;
        for(int i : nums){
            local_max += nums[i];
            if(local_max > ret) ret = local_max;
            if(local_max < 0) local_max=0;
        }
        return ret;
    }

    // solution added on 10/9/2016
    // 16 ms 201 / 201 test cases passed.
    public class Solution {
        public int maxSubArray(int[] nums) {
            int ret = Integer.MIN_VALUE, local_max=0;
            for(int num: nums){
                local_max = Math.max(local_max+num, num);
                ret = Math.max(ret, local_max);
            }
            return ret;
        }
    }
}
