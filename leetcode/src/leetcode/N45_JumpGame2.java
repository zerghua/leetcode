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
    // no company
    // more concise code added on 10/5/2016
    // greedy
    // 11 ms 91 / 91 test cases passed.
    // example 2,1,6,1,1,4 (2-->6-->4)
    public class Solution {
        public int jump(int[] nums) {
            int ret=0, last_jump_max=0, cur_jump_max=0;
            for(int i=0;i<nums.length-1;i++){
                cur_jump_max = Math.max(cur_jump_max, i+nums[i]);
                if(i == last_jump_max){
                    ret++;
                    last_jump_max =cur_jump_max;
                }
            }
            return ret;
        }
    }

    // greedy with pruning on 10/5/2016
    // still 11 ms...
    public class Solution2 {
        public int jump(int[] nums) {
            int ret=0, last_jump_max=0, cur_jump_max=0;
            for(int i=0;i<nums.length-1;i++){
                cur_jump_max = Math.max(cur_jump_max, i+nums[i]);
                if(cur_jump_max >= nums.length-1) return ret+1;  //pruning
                if(i == last_jump_max){
                    ret++;
                    last_jump_max =cur_jump_max;
                }
            }
            return ret;
        }
    }

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
