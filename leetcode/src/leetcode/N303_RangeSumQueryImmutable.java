package leetcode;

/**
 * Created by Hua on 5/23/2016.

 Given an integer array nums, find the sum of the elements
 between indices i and j (i ¡Ü j), inclusive.

 Example:

 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3

 Note:

 You may assume that the array does not change.
 There are many calls to sumRange function.


 */


public class N303_RangeSumQueryImmutable {
    public int[] sum;
    //3 ms
    /*
    public N303_RangeSumQueryImmutable(int[] nums) {
        if(nums == null || nums.length==0) {
            sum=null;
            return;
        }
        sum = new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(sum == null) return 0;
        if(i==0) return sum[j];
        return sum[j] - sum[i-1];
    }
    */


    // cleaner code
    // 3ms
    public N303_RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }




    // Your NumArray object will be instantiated and called as such:
    // NumArray numArray = new NumArray(nums);
    // numArray.sumRange(0, 1);
    // numArray.sumRange(1, 2);
}
