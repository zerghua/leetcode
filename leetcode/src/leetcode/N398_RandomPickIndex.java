package leetcode;

import java.util.Random;

/**
 * Created by Hua on 10/21/2016.

 Given an array of integers with possible duplicates, randomly output the index of a given target number.
 You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 Example:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 solution.pick(3);

 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);


 ReservoirSample(S[1..n], R[1..k])
 // fill the reservoir array
 for i = 1 to k
    R[i] := S[i]

 // replace elements with gradually decreasing probability
 for i = k+1 to n
    j := random(1, i)   // important: inclusive range
    if j <= k
        R[j] := S[i]


 */
public class N398_RandomPickIndex {
    // Facebook
    // Hashtable<value, list_of_its_index> solution, time o(n), space o(n)
    // but good for multiple runs.

    // reservoir sample, make sure each item has the 1/n probability be chosen,
    // good for unknown/large n, time o(n), space o(1).
    // 13 / 13 test cases passed.  on8/18/2017
    // 288 ms
    public class Solution {
        int[] nums;
        Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int ret = 0, count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == target && rand.nextInt(++count) == 0){  // random on [0, n)
                    ret = i;
                }
            }
            return ret;
        }
    }


    // 393 ms 13 / 13 test cases passed.
    public class Solution2 {
        int[] nums;
        Random rand;

        public Solution2(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int ret = 0, count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == target){
                    int j = rand.nextInt(++count);   // random on [0, n)
                    if(j==0) ret = i;
                }
            }
            return ret;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
