package leetcode;

/**
 * Created by Hua on 5/31/2016.

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 */
public class N81_SearchinRotatedSortedArray2 {
    // no company
    //1 ms
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    // 1 ms
    // two situations, depends on where mid lands
    public boolean search(int[] nums, int target, int left, int right){
        if(left > right) return false;
        int mid = (right-left)/2 + left;

        if(nums[mid] == target) return true;
        else if(nums[mid] == nums[left]){
            return search(nums, target, left+1, right);
        }
        else if(nums[mid] > nums[left]){
            if(target < nums[mid] && target >= nums[left]) {
                return search(nums, target, left, mid-1);
            }else return search(nums, target, mid+1, right);
        }else{
            if(target > nums[mid] && target <= nums[right]) {
                return search(nums, target, mid+1, right);
            }else return search(nums, target, left, mid-1);
        }
    }


    // iterative
    // 2 ms
    public boolean search2(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid= (right-left)/2 + left;
            if(nums[mid] == target) return true;
            else if(nums[left] == nums[mid]) left++; // duplicate case
            else if(nums[left] < nums[mid]){         // mid in left larger array
                if(nums[left] <= target && target < nums[mid]) right = mid-1;
                else left = mid+1;
            }else{                                   // mid in right smaller array
                if(nums[mid] < target && target <= nums[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return false;
    }

}
