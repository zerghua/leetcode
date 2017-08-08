package leetcode;

/**
 * Created by HuaZ on 11/12/2016.

 Given a set of intervals, for each of the interval i,
 check if there exists an interval j whose start point is bigger than or equal to
 the end point of the interval i, which can be called that j is on the "right" of i.

 For any interval i, you need to store the minimum interval j's index,
 which means that the interval j has the minimum start point to
 build the "right" relationship for interval i. If the interval j doesn't exist,
 store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

 Note:

 You may assume the interval's end point is always bigger than its start point.
 You may assume none of these intervals have the same start point.

 Example 1:

 Input: [ [1,2] ]

 Output: [-1]

 Explanation: There is only one interval in the collection, so it outputs -1.

 Example 2:

 Input: [ [3,4], [2,3], [1,2] ]

 Output: [-1, 0, 1]

 Explanation: There is no satisfied "right" interval for [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point;
 For [1,2], the interval [2,3] has minimum-"right" start point.

 Example 3:

 Input: [ [1,4], [2,3], [3,4] ]

 Output: [-1, 2, -1]

 Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point.


 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N436_FindRightInterval {
    // no company
    // treemap is red-black tree map implementation, map ordered by key,
    // guarantee o(logn) on containsKey,get, put, remove
    // sort by start of each interval, value is their original index.
    // 39ms 15 / 15 test cases passed.  treemap is o(nlogn) solution, BF is o(n^2) solution
    public class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            if(intervals ==null || intervals.length <= 1) return new int []{-1};
            TreeMap<Integer, Integer> map = new TreeMap();
            int[] ret = new int[intervals.length];
            for(int i=0;i<intervals.length;i++) map.put(intervals[i].start, i); // o(nlogn)
            for(int i=0;i<intervals.length;i++){
                // Returns a key-value mapping associated with the least key
                // greater than or equal to the given key, or null if there is no such key.
                Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end); // binary search
                ret[i] = (entry == null)? -1 : entry.getValue();
            }
            return ret;
        }
    }
}
