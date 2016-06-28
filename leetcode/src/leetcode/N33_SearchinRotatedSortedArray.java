package leetcode;

/**
 * Created by Hua on 4/20/2016.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class N33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    // 1 ms
    // two situations, depends on where mid lands
    public int search(int[] nums, int target, int left, int right){
        if(left > right) return -1;
        int mid = (right-left)/2 + left;

        if(nums[mid] == target) return mid;
        else if(nums[mid] >= nums[left]){
            if(target < nums[mid] && target >= nums[left]) {
                return search(nums, target, left, mid-1);
            }else return search(nums, target, mid+1, right);
        }else{
            if(target > nums[mid] && target <= nums[right]) {
                return search(nums, target, mid+1, right);
            }else return search(nums, target, left, mid-1);
        }
    }

    //1 ms, iterative.
    public int search2(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid= (right-left)/2 + left;
            if(nums[mid] == target) return mid;
            else if(nums[left] <= nums[mid]){        // mid in left larger array
                if(nums[left] <= target && target < nums[mid]) right = mid-1;
                else left = mid+1;
            }else{                                   // mid in right smaller array
                if(nums[mid] < target && target <= nums[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }

}
