package leetcode;

/**
 * Created by Hua on 6/5/2017.

 Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

 Note:
 A naive algorithm of O(n^2) is trivial. You MUST do better than that.

 Example:
 Given nums = [-2, 5, -1], lower = -2, upper = 2,
 Return 3.
 The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

 */
public class N327_CountofRangeSum {
    // Google
    // there is also an sentinel element
    // merge sort, o(nlogn)
    // 61 / 61 test cases passed.
    // 21 ms
    public class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] sum = new long[nums.length+1];
            for(int i=0;i<nums.length;i++){
                sum[i+1] = sum[i] + nums[i];
            }
            return merge(sum, 0, nums.length+1, lower, upper);
        }

        public int merge(long[] sum, int start, int end, int lower, int upper){
            if(end - start <= 1) return 0;
            int mid = start + (end - start)/2;
            int ret = merge(sum, start, mid, lower, upper) + merge(sum, mid, end, lower, upper);
            int j = mid, k = mid, t = mid, r = 0;
            long[] cache = new long[end - start];
            for(int i= start; i<mid; i++){
                // calculate difference in range
                while(j<end && sum[j] - sum[i] < lower) j++;
                while(k<end && sum[k] - sum[i] <= upper) k++;
                ret += k - j;

                // merge array
                while(t<end && sum[t] < sum[i]) cache[r++] = sum[t++];
                cache[r++] = sum[i];
            }
            System.arraycopy(cache, 0, sum, start, t - start);
            return ret;
        }
    }


    // o(n^2) time
    // sum is in range [0, n+1], sum of [0, i)
    // once we converted it to sum array, it becomes point to point calculation
    // so we can effectively sort it even breaking the relative position
    public class Solution_BF {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int ret = 0;
            long[] sum = new long[nums.length+1];
            for(int i=0;i<nums.length;i++){
                sum[i+1] = sum[i] + nums[i];
            }

            for(int i=0;i<nums.length;i++){
                for(int j = i+1; j<=nums.length; j++){
                    if(sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper) ret++;
                }
            }
            return ret;
        }
    }


}
