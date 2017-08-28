package leetcode;

/**
 * Created by Hua on 4/6/2016.

 Implement next permutation,
 which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible,
 it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples.
 Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
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






 on 8/28/2017
 thinking process:(question to ask, how to handle duplicate ones?)

 if:  5 4 3 2 1 -> 1 2 3 4 5, from end to start, all increasing, we reverse all(i == -1)

 if:  3 2 5 4 1 -> 3 4 1 2 5, from end to start, find first non-increasing(i, index=1, val = 2 )
 swap it with the one larger than it(scan from end to left),
 and sort [i+1,end] (can do reverse, because they are sorted)


 */



public class N31_NextPermutation {
    // Google
    // array swap and reverse
    // thinking process see above
    // 265 / 265 test cases passed.  on 8/28/2017
    // 20 ms
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while(i>=0 && nums[i] >= nums[i+1]) i--;  // find the one is not larger than its after

            // not entirely decreasing array as 3 2 1,
            // then find nums[j] > nums[i] from end to i; there must be one, because at least nums[i+1] > nums[i]
            if(i >= 0){
                int j = nums.length - 1;
                while(nums[j] <= nums[i]) j--;
                swap(nums, i, j);
            }

            reverse(nums, i+1, nums.length-1); // reverse [i+1, end] to ensure smallest
        }

        public void swap(int[] a, int left, int right){
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }

        public void reverse(int[] a, int left, int right){
            while(left < right) swap(a, left++, right--);
        }
    }



    // 2 ms
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
