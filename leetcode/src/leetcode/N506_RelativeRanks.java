package leetcode;

import java.util.*;

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
    // Google
    // sort array value with index
    // 17 / 17 test cases passed.  on 8/31/2017
    // 90 ms
    class Solution {
        class Node{
            int val, index;
            Node(int val, int index){
                this.val = val;
                this.index = index;
            }
        }

        public String[] findRelativeRanks(int[] nums) {
            ArrayList<Node> list = new ArrayList();
            int n = nums.length;
            for(int i=0; i<n; i++) list.add(new Node(nums[i], i));
            Collections.sort(list, (a,b) -> b.val - a.val);  // sort by value

            String[] ret = new String[n];
            for(int i=0;i<n; i++){
                ret[list.get(i).index] = (i+1) + "";
                if(n >= 1) ret[list.get(0).index] ="Gold Medal";
                if(n >= 2) ret[list.get(1).index] ="Silver Medal";
                if(n >= 3) ret[list.get(2).index] ="Bronze Medal";
            }
            return ret;
        }
    }


    // custom sort with Integer[]
    // 17 / 17 test cases passed.
    // 113 ms
    public class Solution2 {
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
