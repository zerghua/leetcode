package leetcode;

/**
 * Created by Hua on 6/26/2017.

 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:

 Input: [1,2,3]
 Output: 6

 Example 2:

 Input: [1,2,3,4]
 Output: 24

 Note:

 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 Input:[-4,-3,-2,-1,60]
 Expected:720

 */
import java.util.*;
public class N628_MaximumProductofThreeNumbers {
    // math
    // 83 / 83 test cases passed.
    // 39 ms
    public class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            if(nums[0] >= 0 || nums[n-1] <=0) return nums[n-1]*nums[n-2]*nums[n-3];
            return nums[n-1] * Math.max(nums[0] * nums[1], nums[n-2] * nums[n-3]);
        }
    }

    // concise code
    // 83 / 83 test cases passed.
    // 34 ms
    public class Solution2 {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return nums[n-1] * Math.max(nums[0] * nums[1], nums[n-2] * nums[n-3]);
        }
    }
}
