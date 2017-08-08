package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/20/2016.

 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class N128_LongestConsecutiveSequence {
    // Google, Facebook
    //13 ms
    // use hashset to make it O(N)
    // go through each ele in nums, find it's left and right from itself,
    // remove it from hashset to make it runs faster.
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int e: nums) hs.add(e);

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!hs.contains(num)) continue;

            int cur_max = 1;
            int left=num-1;
            while(hs.contains(left)){
                cur_max++;
                hs.remove(left);
                left--;
            }

            int right = num+1;
            while(hs.contains(right)){
                cur_max++;
                hs.remove(right);
                right++;
            }
            max = Math.max(max, cur_max);
        }

        return max;
    }
}
