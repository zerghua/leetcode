package leetcode;

/**
 * Created by HuaZ on 7/28/2016.

 Given an array nums containing n + 1 integers where each integer is
 between 1 and n (inclusive), prove that at least one duplicate number must exist.
 Assume that there is only one duplicate number, find the duplicate one.

 Note:

 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 // 1,2,3,3
 // 1,1,2,3
 // 1,2,2,3
 // 0,1,2,4,2,3

 */
public class N287_FindtheDuplicateNumber {
    // o(nlogn) time binary search, pigeonhole principle
    // 21 ms
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length-1;
        while(left < right){
            int mid = (right - left)/2 + left;
            int count = 0;
            for(int i: nums) if(i<=mid) count++;
            if(count<=mid) left = mid+1;
            else right = mid;
        }
        return left;
    }

    // o(n) time, loop in a linked list, two points, fast and slow
    // 1 ms
    public int findDuplicate2(int[] nums) {
        int entry=0;
        for(int i=0;i<nums.length;i++){
            if(i != nums[i]) {
                entry = i;
                break;
            }
        }
        int slow = nums[entry], fast = nums[nums[entry]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = entry;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
