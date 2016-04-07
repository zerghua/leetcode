package leetcode;

/**
 * Created by Hua on 4/6/2016.
 */

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
