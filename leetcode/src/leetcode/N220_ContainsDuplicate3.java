package leetcode;

import java.util.*;

/**
 * Created by Hua on 7/24/2016.

 Given an array of integers,
 find out whether there are two distinct indices i and j in the array such that
 the absolute difference between nums[i] and nums[j] is at most t
 and the absolute difference between i and j is at most k.

 Input:[-1,-1]
 1    k
 0    t
 Expected:true

 Input:[-3,3]
 2     k
 4     t
 Expected:false


 Input:[1,2]
 0   k
 1   t
 Expected:false


 Input:[1,3,1]  (good example)
 2   k
 1   t
 Expected:true

 */
public class N220_ContainsDuplicate3 {
    // Airbnb
    // sliding window with max size k, and their max-min diff is less than t
    // TreeSet, time o(nlogk), space k
    // 40 / 40 test cases passed.  on 9/7/2017
    // 53 ms
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(nums == null || nums.length <= 1 || k<0 || t<0) return false;
            TreeSet<Long> treeSet = new TreeSet<>();
            for(int i=0;i<nums.length;i++){
                // check if difference of nums[i] and nums[j] is <= t
                if(treeSet.subSet((long)nums[i]-t, (long)nums[i]+t+1).size() > 0) return true; // can't reverse sequence

                treeSet.add((long)nums[i]);
                if(i>=k) treeSet.remove((long)nums[i-k]); // maintain the window size k
            }
            return false;
        }
    }




    // bucket o(n) solution,
    // https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-using-buckets-with-explanation
}
