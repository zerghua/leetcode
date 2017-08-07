package leetcode;
/*
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

// modified binary search
public class N35_SearchInsertPosition {
    // no company
    // 62 / 62 test cases passed.
    // 6 ms
    public class Solution {
        public int searchInsert(int[] nums, int target) {
            if(nums == null) return 0;
            int l=0, r=nums.length -1;
            while(l<=r){
                int mid = (r-l)/2 + l;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) l = mid+1;
                else r = mid-1;
            }
            return l;
        }
    }


    //0 ms
    public static int searchInsert(int[] nums, int target) {
        if(nums == null) return 0;
        int l=0, r=nums.length -1;
        int insertion_point=0;
        while(l<=r){
            int mid = (r-l)/2 + l;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                l = mid+1;
                insertion_point = mid+1;
            }else{
                r = mid-1;
                if(nums[mid] < nums[insertion_point]) insertion_point = mid-1;
            }
        }
        return insertion_point;
    }




    public static void main(String[] args) {
        //int[] a= {1,3,5,6};
        //int[] a= {1,3,4,5,10};
        int[] a={1,3};
        int target = 0;
        System.out.println(searchInsert(a, target));

    }

}
