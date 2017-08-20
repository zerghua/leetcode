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


 The answer is between maximum value of input array numbers and sum of those numbers.

 Use binary search to approach the correct answer.
 We have l = max number of array; r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;

 Use greedy to narrow down left and right boundaries in binary search.
 3.1 Cut the array from left.

 3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive)
 is large enough but still less than mid.

 3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.

 If we can, it means that the mid value we pick is too small because we've already tried our best
 to make sure each part holds as many non-negative numbers as we can but we still have numbers left.
 So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid.
 We should increase m. This leads to l = mid + 1;

 If we can't, it is either we successfully divide the array into m parts and the sum of each part
 is less than mid, or we used up all numbers before we reach m.
 Both of them mean that we should lower mid because we need to find the minimum one.
 This leads to r = mid - 1;


 Given a result, it is easy to test whether it is valid or not.
 The max of the result is the sum of the input nums.
 The min of the result is the max num of the input nums.
 Given the 3 conditions above we can do a binary search. (need to deal with overflow)


 */
public class N410_SplitArrayLargestSum {
    // Facebook, Baidu
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
