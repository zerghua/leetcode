package leetcode;

/**
 * Created by Hua on 3/21/2016.

 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.
 Note:

 Your solution should be in logarithmic complexity.


 */

// If the middle element is smaller than the its left neighbor,
// then there is always a peak in left half (Why? take few examples).

// If the middle element is smaller than the its right neighbor,
// then there is always a peak in right half

// If array is in ascending or descending order
// then last element or the first element of the array
// will be the peak element respectively.

// disguised binary search o(logn), brute force is o(n)
// binary search guarantee half will be eliminated, there might be
// multiple peaks, we only need to pursue one.


public class N162_FindPeakElement {
    // Microsoft, Google
    // 58 / 58 test cases passed.
    // 0 ms
    public class Solution {
        public int findPeakElement(int[] nums) {
            int left =0, right=nums.length-1;
            while(left<= right){
                int mid = (right-left)/2 + left;

                if( (mid==0 || nums[mid] > nums[mid-1]) &&
                        (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                    return mid;
                }

                else if(mid>0 && nums[mid] < nums[mid-1]) right = mid-1;
                else left = mid+1;
            }

            return 0;
        }
    }


}
