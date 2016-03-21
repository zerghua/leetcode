package leetcode;

/**
 * Created by Hua on 3/21/2016.
 */
public class N80_RemoveDuplicatesfromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if(nums.length ==0) return 0;

        int i=0;
        int allowed_duplicate_times=1;
        int current_duplicate_times=0;
        for(int j=1; j< nums.length ; j++){
            if(nums[i] == nums[j] && current_duplicate_times < allowed_duplicate_times){
                i++;
                nums[i] = nums[j];
                current_duplicate_times++;
            }
            else if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
                current_duplicate_times=0;
            }
        }
        return i+1;
    }


    public int removeDuplicates2(int[] nums) {
        if(nums.length <3) return nums.length;

        int end=1;
        for(int i=2;i<nums.length;i++){
            if(nums[i] != nums[end-1]){
                end++;
                nums[end] = nums[i];
            }
        }
        return end+1;
    }
}
