package leetcode;

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class N153_FindMinimuminRotatedSortedArray {
    //1 ms
    public static int findMin(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == nums[r]) return nums[mid];
            else if(nums[mid] < nums[r]) r = mid;   //highlight, not mid-1
            else l = mid + 1;
        }
        return nums[0];  // or could check if nums[0] < nums[length-1]; if so return nums[0]
    }

    //improved code 1 ms
    public static int findMin2(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]) r = mid;   //highlight, not mid-1
            else l = mid + 1;
        }
        return nums[l];
    }

    // optimized code added on 10/9/2016
    // 0 ms 146 / 146 test cases passed.
    public class Solution {
        public int findMin(int[] nums) {
            if(nums == null || nums.length==0) return -1;
            int l=0, r=nums.length-1;
            while(l<r && nums[l] >= nums[r]){ //hightlight not l<=r
                int mid = l + (r-l)/2;
                if(nums[mid] < nums[r]) r = mid;   //highlight, not mid-1
                else l = mid + 1;
            }
            return nums[l];
        }
    }


    public static void main(String[] args) {
        int[] a= {4,5,6,7,2};
        //int[] a= {0,1,2,3,4,5};
        System.out.println(findMin(a));

    }
}
