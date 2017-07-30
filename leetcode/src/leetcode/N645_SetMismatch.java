package leetcode;

/**
 * Created by HuaZ on 7/30/2017.
 *
 The set S originally contains numbers from 1 to n.
 But unfortunately, due to the data error, one of the numbers in the set
 got duplicated to another number in the set, which results in repetition of one number
 and loss of another number.

 Given an array nums representing the data status of this set after the error.
 Your task is to firstly find the number occurs twice and then find the number that is missing.
 Return them in the form of an array.

 Example 1:

 Input: nums = [1,2,2,4]
 Output: [2,3]

 Note:

 The given array size will in the range [2, 10000].
 The given array's numbers won't have any order.


 */
public class N645_SetMismatch {
    // amazon
    // o(n) space, o(n) time
    // 49 / 49 test cases passed.
    // 9 ms
    public class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] a = new int[nums.length + 1];
            int ret=0;
            for(int i=0;i<nums.length; i++){
                a[nums[i]]++;
                if(a[nums[i]] == 2) ret = nums[i];
            }
            for(int i=1;i<a.length;i++){
                if(a[i] == 0) return new int[]{ret, i};
            }
            return null;
        }
    }


    // o(1) space, o(n) time
    // 49 / 49 test cases passed.
    // 11 ms
    public class Solution2 {
        public int[] findErrorNums(int[] nums) {
            int[] ret = new int[2];
            for(int e : nums){
                if(nums[Math.abs(e) - 1] < 0) ret[0] = Math.abs(e);
                else nums[Math.abs(e) - 1] *= -1;
            }
            for(int i=0; i<nums.length; i++) if(nums[i] > 0) ret[1] = i+1;
            return ret;
        }
    }
}
