package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/23/2016.
 *
 * Given an unsorted array, find the maximum difference
 * between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers
 and fit in the 32-bit signed integer range.
 */
public class N164_MaximumGap {
    // no company
    // direct solution
    // o(nlogn)
    // 4 ms
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int gap=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length; i++){
            gap = Math.max(gap, nums[i] - nums[i-1]);
        }
        return gap;
    }

    /* or
 Suppose there are N elements and they range from A to B.

Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)],
then we will have at most num = (B - A) / len + 1 of bucket

for any number K in the array, we can easily find out
which bucket it belongs by calculating loc = (K - A) / len and
therefore maintain the maximum and minimum elements in each bucket.

Since the maximum difference between elements in the same buckets
will be at most len - 1, so the final answer will not be taken from
two elements in the same buckets.

For each non-empty buckets p,
find the next non-empty buckets q,
then q.min - p.max could be the potential answer to the question.
Return the maximum of all those values.

     */
}
