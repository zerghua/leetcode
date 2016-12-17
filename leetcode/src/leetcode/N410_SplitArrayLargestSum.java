package leetcode;

/**
 * Created by HuaZ on 12/16/2016.

 Given an array which consists of non-negative integers and an integer m,
 you can split the array into m non-empty continuous subarrays. Write an algorithm to
 minimize the largest sum among these m subarrays.

 Note:
 Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.

 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.

 https://discuss.leetcode.com/topic/61324/clear-explanation-8ms-binary-search-java/2

 */
public class N410_SplitArrayLargestSum {
    // not sure why it's right, might need proof.
    // 9 ms 28 / 28 test cases passed.
    // binary search
    public class Solution {
        public int splitArray(int[] nums, int m) {
            int max = 0; long sum =0;
            for(int n: nums){
                max = Math.max(max, n);
                sum += n;
            }
            if(m == 1) return (int)sum;
            long l = max, r = sum, mid = 0;
            while(l<=r){
                mid = (l+r)/2;
                if(isLeftCanDivide(mid, nums, m)) r = mid - 1;
                else l = mid+1;
            }
            return (int)l;
        }

        public boolean isLeftCanDivide(long target, int[] nums, int m){
            int count = 1; long sum = 0;
            for(int n: nums){
                sum += n;
                if(sum > target){
                    sum = n;
                    count++;
                    if(count > m) return false;
                }
            }
            return true;
        }
    }
}
