package leetcode;

/**
 * Created by Hua on 3/27/2016.

 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].


 I like this problem and solution, two recursive call inside equal condition.

 */
public class N34_SearchforaRange {
    // Linkedin
    // 87 / 87 test cases passed.
    // 8 ms
    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ret = {-1, -1};
            if(nums == null) return ret;
            binarySearch(nums, target, 0, nums.length-1, ret);
            return ret;
        }


        public void binarySearch(int[] nums, int target, int start, int end, int[] ret){
            if(start<=end){
                int mid = (end - start)/2 + start;
                if(nums[mid] == target){
                    if(mid < ret[0] || ret[0] == -1) ret[0] = mid;
                    if(ret[1] < mid || ret[1] == -1) ret[1] = mid;

                    binarySearch(nums, target, start, mid-1, ret);
                    binarySearch(nums, target, mid+1, end, ret);
                }else if (nums[mid] < target){
                    binarySearch(nums, target, mid+1, end, ret);
                }else binarySearch(nums, target, start, mid-1, ret);
            }
        }
    }


}
