package leetcode;
import java.util.*;
/**
 * Created by HuaZ on 10/13/2016.

 Given a sorted integer array where the range of elements are [lower, upper] inclusive,
 return its missing ranges.

 For example, given [0, 1, 3, 50, 75],
 lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

 Understand the problem:
 The problem itself is not hard at all. The key is to handle several corner cases. e.g.
 -- If the array is empty, the missing ranges should be from lower to upper, inclusive.

 -- For the leading missing range, e.g. -2 , [-1], -1. The output should be "-2".
 Note that the lower bound is inclusive.

 -- For the trailing missing range, e.g. -2, [-2], 1, the output should be "-1->1".
 The upper bound is inclusive as well.

 */
public class N163_MissingRanges {
    // google
    // fix max and min Integer using Long type
    // Two pointers, and two sentinels for concise code.
    // cur-pre>1
    // 40 / 40 test cases passed.  7/23/2017
    // 1 ms
    public class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> ret = new ArrayList();
            Long pre = (long)lower-1;  //for corner case of first one should be included
            for(int i=0;i<=nums.length;i++){
                long cur = (i == nums.length)?(long)upper+1 : nums[i];  // upper+1 for corner case of last one included
                if(cur - pre > 1) ret.add(addString((long)pre+1, (long)cur-1));
                pre = cur;
            }
            return ret;
        }
        public String addString(long from, long to){
            return (from == to)? ""+from : from + "->" + to;
        }
    }



    //  bug when lower=Integer.MIN_VALUE and upper = Integer.MAX_VALUE;
    public class Solution2 {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> ret = new ArrayList();
            int pre = lower-1;
            for(int i=0;i<=nums.length;i++){
                int cur = (i == nums.length)?upper+1 : nums[i];
                if(cur - pre >= 2) ret.add(addString(pre+1, cur-1));
                pre = cur;
            }
            return ret;
        }
        public String addString(int from, int to){
            return (from == to)? ""+from : from + "->" + to;
        }
    }




    public static void main(String[] args){
        N163_MissingRanges.Solution x = new N163_MissingRanges().new Solution();
        System.out.println(x.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
        System.out.println(x.findMissingRanges(new int[]{}, 0, 99));
        System.out.println(x.findMissingRanges(new int[]{}, 0, Integer.MAX_VALUE));
        System.out.println(x.findMissingRanges(new int[]{}, Integer.MIN_VALUE, Integer.MAX_VALUE));

        N163_MissingRanges.Solution2 y = new N163_MissingRanges().new Solution2();
        System.out.println(y.findMissingRanges(new int[]{}, 0, Integer.MAX_VALUE));
        System.out.println(y.findMissingRanges(new int[]{}, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
