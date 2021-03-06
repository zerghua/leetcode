package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/9/2016.

 Given an array S of n integers, are there elements a, b, c, and d
 in S such that a + b + c + d = target? Find all unique quadruplets
 in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
 ]


 */
public class N18_4Sum {
    // no company
    //41 ms
    //a more general solution of kSum with backtracking
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums.length<4) return ret;
        Arrays.sort(nums);
        kSum(nums, 0,nums.length-1, target, 4, new LinkedList<Integer>(), ret);
        return ret;
    }

    public void kSum(int[] nums, int left, int right, int target, int k,
        LinkedList<Integer> list, List<List<Integer>> ret){
            //TODO k<2

            if(k==2) {
                twoSum(nums, left, right, target, list,ret);
                return;
            }

        for(int i=left; i<nums.length-k+1;i++){
            if(i>left && nums[i] == nums[i-1]) continue; //skip duplicate of i
            list.add(nums[i]);
            kSum(nums, i+1, right, target-nums[i], k-1, list, ret);
            list.removeLast();
        }
    }

    public void twoSum(int[] nums, int left, int right, int target,
                       List<Integer> list, List<List<Integer>> ret){
        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                LinkedList<Integer> new_list = new LinkedList<>(list);
                new_list.add(nums[left]);
                new_list.add(nums[right]);
                ret.add(new_list);
                left++; right--;

                // skip duplicate of left and right
                while(left<right && nums[left] == nums[left-1]) left++;
                while(left<right && nums[right] == nums[right+1]) right--;
            }
            else if (sum > target) right--;
            else left++;
        }
    }
}
