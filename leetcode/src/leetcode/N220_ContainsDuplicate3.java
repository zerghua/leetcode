package leetcode;

import java.util.TreeSet;

/**
 * Created by Hua on 7/24/2016.

 Given an array of integers, find out whether
 there are two distinct indices i and j in the array
 such that the difference between nums[i] and nums[j]
 is at most t and the difference between i and j is at most k.

 */
public class N220_ContainsDuplicate3 {
    // 52 ms TreeSet, time o(nlogk), space k
    // bucket o(n) solution,
    // https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-using-buckets-with-explanation
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k<0 || t<0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            // check if difference of nums[i] and nums[j] is <= t
            if(!treeSet.subSet((long)nums[i]-t, (long)nums[i]+t+1).isEmpty())
                return true;

            treeSet.add((long)nums[i]);
            if(i>=k) treeSet.remove((long)nums[i-k]); // maintain the window size k
        }
        return false;
    }
}
