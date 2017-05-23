package leetcode;

/**
 * Created by Hua on 5/23/2017.

 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 You are asked to burst all the balloons.
 If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */
public class N312_BurstBalloons {
    // hard. DP + memo + divide and conquer
    // 70 / 70 test cases passed.
    // 9 ms
    public class Solution {
        public int maxCoins(int[] nums) {
            int[] a = new int[nums.length+2];
            int n = 1;
            for(int num: nums) if(num != 0) a[n++] = num;  //skip 0

            a[0] = a[n++] = 1;
            int[][] memo = new int[n][n];
            return dfs(a, memo, 0, n-1);
        }

        public int dfs(int[] a, int[][] memo, int left, int right){
            if(left + 1 == right) return 0;
            if(memo[left][right] > 0) return memo[left][right];

            int ret = 0;
            for(int i = left + 1; i< right; i++){
                ret = Math.max(ret, a[left] * a[i] * a[right] + dfs(a, memo, left, i) + dfs(a, memo, i, right));
            }

            memo[left][right] = ret;
            return ret;
        }
    }

}
