package leetcode;
import java.util.Arrays;

/**
 * Created by Hua on 3/27/2016.

 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


 */
public class N16_3SumClosest {
    // Bloomberg
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
