package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Hua on 5/11/2017.

 Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:

 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores,
 so they got "Gold Medal", "Silver Medal" and "Bronze Medal".

 For the left two athletes, you just need to output their relative ranks according to their scores.

 Note:

 N is a positive integer and won't exceed 10,000.
 All the scores of athletes are guaranteed to be unique.


 */
public class N506_RelativeRanks {
    // custom sort with Integer[]
    // 17 / 17 test cases passed.
    // 113 ms
    public class Solution {
        public String[] findRelativeRanks(int[] nums) {
            String[] ret = new String[nums.length];
            Integer[] index = new Integer[nums.length];
            for(int i=0; i< nums.length; i++) index[i] = i;

            Arrays.sort(index, (a, b) -> nums[b] - nums[a]);  // important sort on original value

            for(int i=0;i<nums.length;i++) ret[index[i]] = "" + (i+1);
            if(nums.length >= 1) ret[index[0]] = "Gold Medal";
            if(nums.length >= 2) ret[index[1]] = "Silver Medal";
            if(nums.length >= 3) ret[index[2]] = "Bronze Medal";
            return ret;
        }
    }

}