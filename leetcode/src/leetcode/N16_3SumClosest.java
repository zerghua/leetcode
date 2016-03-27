package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 3/27/2016.
 */
public class N16_3SumClosest {
    // o(n^2) time,
    // assume there is a solution
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min_diff = Integer.MAX_VALUE;
        int ret=0;

        for(int i=0; i< nums.length-2; i++){
            int start = i+1, end=nums.length-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target) return target;
                else if(sum< target) start++;
                else end--;

                int cur_diff = Math.abs(sum-target);
                if( cur_diff < min_diff) {
                    min_diff = cur_diff;
                    ret = sum;
                }
            }
        }

        return ret;
    }
}
