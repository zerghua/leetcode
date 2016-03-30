package leetcode;

/**
 * Created by Hua on 3/30/2016.
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
}
