package leetcode;

/**
 * Created by Hua on 4/6/2016.

 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1


 the hard part is to understand what is "lexicographically next greater permutation of numbers"
 1,2,3,4,5,6
 1,2,3,4,6,5
 1,2,3,5,4,6
 1,2,3,5,6,4
 1,2,3,6,4,5
 1,2,3,6,5,4
 1,2,4,3,5,6




 4,5,6,3,2,1   ->  4,6,1,2,3,5
   | |
   p q



 break down of above:

 1.  from right to left, find the first element that is less than its previous one.



 */

// Google
// http://www.programcreek.com/2014/06/leetcode-next-permutation-java/
// 2 ms
public class N31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int change_index=0, next_index=0;

        // scan from right to left,
        // find the first element that is less than its previous one.
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]) {
                change_index = i;
                break;
            }
        }

        // scan from right to left,
        // find the first element that is greater than p.
        for (int i = nums.length - 1; i > change_index; i--) {
            if (nums[i] > nums[change_index]) {
                next_index = i;
                break;
            }
        }

        if(change_index == 0 && next_index==0) reverse(nums, 0, nums.length-1);
        else{
            swap(nums, change_index, next_index);
            reverse(nums, change_index+1, nums.length-1);
        }
    }


    public void reverse(int[] a, int left, int right){
        while(left < right){
            swap(a, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] a, int left, int right){
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

}
