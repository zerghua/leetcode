package leetcode;

/**
 * Created by Hua on 3/27/2016.
 */
public class N34_SearchforaRange {
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


    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums == null) return ret;
        binarySearch(nums, target, 0, nums.length-1, ret);
        return ret;
    }
}
