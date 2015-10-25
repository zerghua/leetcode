package leetcode;
/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0    

mid=0, l=0, r=1    	
// [1,3]  2   mid[0] < target  -->  l=mid+1 -->  l=1 r=1, --> l=1, r=0 -->return l;
// [1,3]  4   mid[0] < target  -->  l=mid+1 -->  l=1 r=1, --> l=2, r=1 -->return l;
// [1,3]  0   target < mid[0]  -->  r=mid-1 -->  l=0 r=-1 --> return l;
 * if not found, return lower bound.
 */

// modified binary search
public class N35_SearchInsertPosition {
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

    //0 ms 
    public static int searchInsert2(int[] nums, int target) {
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


    public static void main(String[] args) {
        //int[] a= {1,3,5,6};
        //int[] a= {1,3,4,5,10};
        int[] a={1,3};
        int target = 0;
        System.out.println(searchInsert(a, target));

    }

}
