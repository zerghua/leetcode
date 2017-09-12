package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Given an unsorted array nums, reorder it in-place such that
 nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

 */
public class N280_WiggleSort {
    // Google (Premium)
    // 126 / 126 test cases passed.
    // 1 ms
    public class Solution {
        public void wiggleSort(int[] nums) {
            for(int i=1; i<nums.length; i++){
                if((i % 2 == 1 && nums[i-1] > nums[i]) || (i % 2 == 0 && nums[i-1] < nums[i])){ //swap
                    int tmp = nums[i-1];
                    nums[i - 1] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    // 126 / 126 test cases passed.
    // 1 ms
    public class Solution2 {
        public void wiggleSort(int[] nums) {
            for(int i=1; i<nums.length; i++){
                int a = nums[i-1];
                if((i % 2 == 1) == (a > nums[i])){ // two situations to switch with previous one
                    nums[i - 1] = nums[i];
                    nums[i] = a;
                }
            }
        }
    }
}
