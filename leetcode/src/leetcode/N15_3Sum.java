package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/9/2016.
 *
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
     [-1, 0, 1],
     [-1, -1, 2]
 ]

 *
 */
public class N15_3Sum {
    // Amazon, Microsoft, Facebook
    // 8 ms  O(n^2) time
    // remember Arrays.asList to create a list with some initial values.
    // two pointers makes it o(n)
    // outer loop make it another o(n)
    // look at how to skip duplicate elements
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums.length<3) return ret;

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //skip duplicate of i

            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;

                    // skip duplicate of left and right
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;
                }
                else if (sum > 0) right--;
                else left++;
            }
        }
        return ret;
    }
}
