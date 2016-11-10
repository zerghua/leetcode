package leetcode;

/**
 * Created by HuaZ on 11/9/2016.

 Given a non-empty integer array of size n,
 find the minimum number of moves required to make all array elements equal,
 where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 https://discuss.leetcode.com/topic/66557/java-o-n-solution-short

 Add 1 to n - 1 elements is the same as subtracting 1 from one element,
 w.r.t goal of making the elements in the array equal.
 So, best way to do this is make all the elements in the array equal to the min element.
 sum(array) - n * minimum

 */
public class N453_MinimumMovestoEqualArrayElements {
    // math, and thinking from the opposite way.
    // 84 ms 84 / 84 test cases passed.
    public class Solution {
        public int minMoves(int[] nums) {
            if(nums == null || nums.length==0) return 0;
            int min = nums[0], ret = 0;
            for(int n : nums) min = Math.min(min, n);
            for(int n : nums) ret += n - min;
            return ret;
        }
    }
}
