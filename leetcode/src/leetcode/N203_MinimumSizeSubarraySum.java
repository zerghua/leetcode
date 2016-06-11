package leetcode;

/**
 * Created by Hua on 6/5/2016.

 Given an array of n positive integers and a positive integer s,
 find the minimal length of a subarray of which the sum �� s.
 If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.
 More practice:

 If you have figured out the O(n) solution, try coding another solution of
 which the time complexity is O(n log n).


 */
public class N203_MinimumSizeSubarraySum {
    // store two pointers point to front and end which sum of between >=s
    // 1 ms
    // sliding window.
    public int minSubArrayLen(int s, int[] nums) {
        int front=0, min = Integer.MAX_VALUE, sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum>=s) {
                //advance front
                while(sum-nums[front] >=s){
                    sum -= nums[front];
                    front++;
                }
                min = Math.min(min, i-front+1); //update min
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}