package leetcode;

/**
 * Created by Hua on 7/6/16.



 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.

 */
public class N154_FindMinimuminRotatedSortedArray2 {
    // no company
    // 1 ms
    // get rid of end, when nums[mid] == nums[end]
    public int findMin(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] == nums[r]) r--;
            else if(nums[mid] < nums[r]) r = mid;   //highlight, not mid-1
            else l = mid + 1;
        }
        return nums[l];
    }

    // optimized code added on 10/9/2016
    // 1 ms 191 / 191 test cases passed.
    public class Solution {
        public int findMin(int[] nums) {
            if(nums == null || nums.length==0) return -1;
            int l=0, r=nums.length-1;
            while(l<r && nums[l]>=nums[r]){
                int mid = l + (r-l)/2;
                if(nums[mid] == nums[r]) r--;
                else if(nums[mid] < nums[r]) r = mid;   //highlight, not mid-1
                else l = mid + 1;
            }
            return nums[l];
        }
    }

    public static void main(String[] args) {
        //int[] a= {4,5,6,7,2,2,2};
        //int[] a= {1,3,3};
        //int[] a= {6,3,3};
        //int[] a= {0,1,2,3,4,5};
        int[] a = {3,3,1,3};
        N154_FindMinimuminRotatedSortedArray2 x = new N154_FindMinimuminRotatedSortedArray2();
        System.out.println(x.findMin(a));

    }
}
