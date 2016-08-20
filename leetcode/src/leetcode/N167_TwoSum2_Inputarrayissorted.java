package leetcode;

/**
 * Created by Hua on 8/20/16.


 Given an array of integers that is already sorted in ascending order,
 find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 */
public class N167_TwoSum2_Inputarrayissorted {
    // 2ms o(n) time, two pointers.
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1, tmp=0;
        while((tmp = numbers[l] + numbers[r]) != target){
            if(tmp > target) r--;
            else l++;
        }
        return new int[]{l+1, r+1};
    }
}
