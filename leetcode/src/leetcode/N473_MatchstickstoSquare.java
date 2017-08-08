package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 5/18/2017.

 Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 please find out a way you can make one square by using up all those matchsticks. You should not break any stick,
 but you can link them up, and each matchstick must be used exactly one time.

 Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be
 true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

 Example 1:

 Input: [1,1,2,2,2]
 Output: true

 Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

 Example 2:

 Input: [3,3,3,3,4]
 Output: false

 Explanation: You cannot find a way to form a square with all the matchsticks.

 Note:

 The length sum of the given matchsticks is in the range of 0 to 10^9.
 The length of the given matchstick array will not exceed 15.

 */
public class N473_MatchstickstoSquare {
    // Rackspace
    // tricky DFS, has to sort and start from end to speed up
    // 174 / 174 test cases passed.
    // 48 ms
    public class Solution {
        public boolean makesquare(int[] nums) {
            long sum = 0;
            for(int i: nums) sum += i;
            if(sum%4 != 0 || nums.length < 4) return false;
            long side = sum / 4;
            Arrays.sort(nums);
            return dfs(nums, nums.length-1, 0, 0, 0, 0, side);
        }

        public boolean dfs(int[] nums, int start, long a, long b, long c, long d, long side){
            if(a > side || b > side || c > side || d > side) return false;
            if(start == -1){
                if(a == side && b == side && c == side && d == side) return true;
                return false;
            }
            return  dfs(nums, start - 1, a + nums[start], b, c, d, side) ||
                    dfs(nums, start - 1, a, b + nums[start], c, d, side) ||
                    dfs(nums, start - 1, a, b, c + nums[start], d, side) ||
                    dfs(nums, start - 1, a, b, c, d + nums[start], side) ;
        }
    }

}
