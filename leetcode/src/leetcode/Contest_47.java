package leetcode;

/**
 * Created by HuaZ on 8/26/2017.
 1196 / 2554	zerghua	0	0:00:00
 solved non

 */
public class Contest_47 {
    // [3,4,2,3]  false
    // [4,2,1]    false
    // [2,3,3,2,4]  true
    // [4,2,3]    true
    class Solution {
        public boolean checkPossibility(int[] nums) {
            if(nums.length <= 2) return true;

            // fix once
            for(int i=1; i<nums.length; i++){
                if(nums[i] < nums[i-1]) {
                    nums[i] = nums[i-1];
                    break;
                }
            }

            for(int i=1; i<nums.length; i++) {
                if(nums[i-1] > nums[i]) return false;
            }
            return true;
        }
    }

    // bottom up
    // [111,217,221,315,415]  20
    class Solution2 {
        public int pathSum(int[] nums) {
            if(nums.length==1) return nums[0]%10;
            int[] ret = new int[nums.length];
            int last = nums[nums.length-1]/100;
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]/100==last) ret[i] = nums[i]%10;
            }

            for(int i=nums.length -1; i>0; i--){
                int val = nums[i]%10;
                int cur = nums[i]/10;
                int parent = (cur%10 + 1)/2 + (cur/10 - 1) * 10;
                for(int j=i-1; j>=0;j--){
                    if(nums[j] / 10 == parent){
                        ret[j] += nums[j]%10 +  ret[i];
                        break;
                    }
                }
            }
            return ret[0];
        }
    }
}
