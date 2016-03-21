package leetcode;

/**
 * Created by Hua on 3/21/2016.
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

    public static void main(String[] args) {
        int[] a= {1,2};
        //int[] a= {0,1,2,3,4,5};
        N162_FindPeakElement x= new N162_FindPeakElement();
        System.out.println(x.findPeakElement(a));

    }
}
