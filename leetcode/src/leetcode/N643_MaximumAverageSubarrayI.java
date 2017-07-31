package leetcode;

/**
 * Created by Hua on 7/31/2017.

 Given an array consisting of n integers, find the contiguous subarray of given length k that has
 the maximum average value. And you need to output the maximum average value.

 Example 1:

 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

 Note:

 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].


 */
public class N643_MaximumAverageSubarrayI {
    // google
    // sliding window
    // 123 / 123 test cases passed.
    // 26 ms
    public class Solution {
        public double findMaxAverage(int[] nums, int k) {
            long sum =0;
            int i=0, j=0;
            while(j<k) sum += nums[j++];
            double ret = 1.0* sum / k;

            while(j<nums.length){
                sum -= nums[i++];
                sum += nums[j++];
                ret = Math.max(ret, 1.0*sum/k);
            }
            return ret;
        }
    }


    // faster code
    // 123 / 123 test cases passed.
    // 18 ms
    public class Solution2 {
        public double findMaxAverage(int[] nums, int k) {
            int i=0, j=0;
            long sum = 0;
            while(j<k) sum += nums[j++];
            long max = sum;

            while(j<nums.length){
                sum -= nums[i++];
                sum += nums[j++];
                max = Math.max(max, sum);
            }
            return 1.0*max / k;
        }
    }
}
