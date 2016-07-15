package leetcode;
import java.util.*;

/**
 * Created by Hua on 7/14/2016.

 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that
 you cannot load all elements into the memory at once?


 */
public class N350_IntersectionofTwoArrays2 {
    // 8 ms
    // hashmap
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e: nums1) map.put(e, map.getOrDefault(e, 0) + 1);

        List<Integer> ret = new ArrayList<>();
        for(int e: nums2) {
            if(map.containsKey(e)){
                ret.add(e);
                int count = map.get(e) - 1;
                if(count == 0 ) map.remove(e);
                else map.put(e, count);
            }
        }

        int[] r= new int[ret.size()];
        int i=0;
        for(int e: ret) r[i++] = e;
        return r;
    }
}
