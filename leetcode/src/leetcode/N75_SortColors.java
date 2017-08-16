package leetcode;

/**
 Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors
 in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent
 the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's,
 then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */
public class N75_SortColors {
    // Microsoft, Facebook
    // added on 10/1/2016
    // 0 ms 86 / 86 test cases passed.
    public class Solution {
        public void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        public void sortColors(int[] nums) {
            int left=0, right=nums.length-1, i=0;
            while(i<=right){
                if(nums[i] == 0) {
                    swap(nums, i++, left++);
                }else if(nums[i] == 2){
                    swap(nums, i, right--);
                }else  i++;
            }
        }
    }


    //counting sort added on 10/1/2016
    // 0 ms 86 / 86 test cases passed.
    public class Solution2 {
        public void sortColors(int[] nums) {
            int zero=0, one=0, two=0;
            for(int n:nums){
                if(n==0) zero++;
                else if (n==1) one++;
                else two++;
            }

            int i=0;
            while(zero-->0) nums[i++]=0;
            while(one-->0) nums[i++]=1;
            while(two-->0) nums[i++]=2;
        }
    }


    public void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //1 ms
    public void sortColors(int[] nums) {
        int left=0, right=nums.length-1, i=0;
        while(i<=right){
            if(nums[i] == 0) {
                swap(nums, i, left);
                i++;left++;
            }else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }else  i++;
        }
    }





}
