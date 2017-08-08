package leetcode;

/**
 * Created by Hua on 7/13/2017.

 Given a sorted array consisting of only integers where every element appears twice except for one element
 which appears once. Find this single element that appears only once.

 Example 1:

 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2

 Example 2:

 Input: [3,3,7,7,10,11,11]
 Output: 10

 Note: Your solution should run in O(log n) time and O(1) space.


 */
public class N540_SingleElementinaSortedArray {
    // no company
    // 7 / 7 test cases passed.
    // 1 ms
    // binary search, based on odd and even numbers of the two halves.
    public class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0, right = nums.length-1;
            while(left <= right){
                int mid = (right - left)/2 + left;
                if(mid == 0  || mid == nums.length-1 || (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])) return nums[mid];

                if((nums[mid] == nums[mid+1] && (nums.length - 1 - mid) % 2 == 1) || (nums[mid] == nums[mid-1] && (mid - 0) % 2 == 0)) right = mid-1;                else left = mid + 1;
            }
            return 0;
        }
    }


    // another interesting solution
    // My solution using binary search. lo and hi are not regular index, but the pair index here.
    // Basically you want to find the first even-index number not followed by the same number.
    public class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            // binary search
            int n=nums.length, lo=0, hi=n/2;
            while (lo < hi) {
                int m = (lo + hi) / 2;
                if (nums[2*m]!=nums[2*m+1]) hi = m;
                else lo = m+1;
            }
            return nums[2*lo];
        }
    }


}
