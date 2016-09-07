package leetcode;

/**
 * Created by Hua on 3/30/2016.

 Given an array of non-negative integers, you are initially positioned
 at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 */
public class N55_JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;

        int max_index=0;
        int cur_index;
        int last_index=nums.length-1;
        for(int i=0; i<last_index;i++){
            if(i>max_index) break; // no need to continue

            cur_index = i + nums[i];
            if(cur_index >= last_index) return true;
            else if(cur_index > max_index) max_index = cur_index;
        }
        return false;
    }


    // version 2 added on 9/7/2016
    // 4 ms  72 / 72 test cases passed.
    // array operation. o(n), scan each item and exit early if possible.
    public class Solution {
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length <= 1) return true;
            int max_jump=0, last_index= nums.length -1;
            for(int i=0;i<last_index;i++){
                if (i > max_jump) break; // pruning

                max_jump = Math.max(i+ nums[i], max_jump);
                if(max_jump >= last_index) return true;
            }
            return false;
        }
    }
}
