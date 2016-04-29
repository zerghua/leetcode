package leetcode;

/**
 * Created by Hua on 4/29/2016.
 *
 *  Given an array of non-negative integers, you are initially positioned
 *  at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2.
 (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */
public class N45_JumpGame2 {
    // 3 ms, DP
    // can also use greedy, no need to store each point,
    // just store the max
    public int jump(int[] nums) {
        if(nums == null || nums.length == 1) return 0;
        int[] min_steps = new int[nums.length];
        int last_max_index = 0;
        for(int i=0;i<nums.length;i++){
            int cur_index = i + nums[i];
            if(cur_index >= nums.length - 1) return min_steps[i] + 1;
            else if(cur_index > last_max_index){
                for(int j=i+1; j<=cur_index;j++){
                    if(min_steps[j] == 0) min_steps[j] = min_steps[i]+1;
                    else min_steps[j] = Math.min(min_steps[j], min_steps[i] + 1);
                }
                last_max_index = cur_index;
            }
        }
        return min_steps[nums.length-1];
    }
}
