package leetcode;

import java.util.HashSet;

/**
 * Created by Hua on 5/18/2016.
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:

 Each element in the result must be unique.
 The result can be in any order.


 */
public class N349_IntersectionofTwoArrays {
    // Two Sigma
    // 7 ms
    // hashset
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        for(int e: nums1) hs.add(e);

        HashSet<Integer> ret = new HashSet<>();
        for(int e: nums2) if(hs.contains(e)) ret.add(e);

        int[] r = new int[ret.size()];
        int count=0;
        for(int e: ret)r[count++] = e;

        return r;
    }
}
