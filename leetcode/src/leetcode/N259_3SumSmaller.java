package leetcode;
import java.util.Arrays;

/**
 * Created by Hua on 7/17/2017.


 Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]

 Follow up:
 Could you solve it in O(n^2) runtime?

 */
public class N259_3SumSmaller {
    // Google
    // 313 / 313 test cases passed.
    // 10 ms
    // sort + two pointers, similar to 3sums
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if(nums == null || nums.length < 3) return 0;
            Arrays.sort(nums);
            int ret =0, n = nums.length;
            for(int i=0; i<n ; i++){
                int l = i + 1, h = n - 1;
                while(l < h){
                    if(nums[i] + nums[l] + nums[h] < target){
                        ret += h - l;
                        l++;
                    }else h--;
                }
            }
            return ret;
        }
    }
}
