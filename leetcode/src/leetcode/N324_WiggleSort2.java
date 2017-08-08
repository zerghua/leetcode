package leetcode;

import java.util.Arrays;

/**
 * Created by HuaZ on 8/9/2016.

 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?

 */
public class N324_WiggleSort2 {
    // Google
    // 8 ms, o(nlogn) solution. sort and rearrange.
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length<=1) return;
        int[] tmp = new int[nums.length];
        Arrays.sort(nums);
        int left= (nums.length - 1)/2, right = nums.length - 1;
        for(int i=0;i<nums.length;i++){
            tmp[i] = (i & 1) == 0 ? nums[left--] : nums[right--];
        }
        System.arraycopy(tmp,0,nums,0,nums.length);
    }

}
