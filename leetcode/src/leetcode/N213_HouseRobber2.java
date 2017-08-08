package leetcode;

/**
 * Created by Hua on 6/1/2016.

 Note: This is an extension of House Robber. N198

 After robbing those houses on that street, the thief has found himself a new place
 for his thievery so that he will not get too much attention. This time, all houses
 at this place are arranged in a circle. That means the first house is the neighbor
 of the last one. Meanwhile, the security system for these houses remain the same
 as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class N213_HouseRobber2 {
    // Mircosoft
    // 1 ms
    // reused the solution from N198 with a trick to handle circle
    // DP, if circle, two times of DP, one remove head, another remove tail.
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob_helper(nums, 0, nums.length-1), rob_helper(nums,1,nums.length));
    }

    public int rob_helper(int[] nums, int left, int right){
        int even=0, odd=0;
        for(int i=left;i<right;i++){
            if(i%2 == 0){
                even += nums[i];
                even = Math.max(even, odd);
            }else{
                odd += nums[i];
                odd = Math.max(even, odd);
            }
        }
        return Math.max(odd, even);
    }
}
