package leetcode;

/**
 * Created by HuaZ on 11/11/2016.

 Given a collection of intervals, find the minimum number of intervals
 you need to remove to make the rest of the intervals non-overlapping.

 Note:

 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

 Example 1:

 Input: [ [1,2], [2,3], [3,4], [1,3] ]

 Output: 1

 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

 Example 2:

 Input: [ [1,2], [1,2], [1,2] ]

 Output: 2

 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

 Example 3:

 Input: [ [1,2], [2,3] ]

 Output: 0

 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


 */
import leetcode.N0_data_strcture.*;
import java.util.*;
public class N435_NonoverlappingIntervals {
    // no company
    // greedy, keep track of end interval.
    // sort by start and end, remove adjacent interval which has larger end.
    // very similar to N452.
    // 10ms  18 / 18 test cases passed.
    public class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if(intervals == null || intervals.length < 2) return 0; // performs better when < 2 rather than ==0
            Arrays.sort(intervals, (a,b) -> a.start==b.start? a.end-b.end : a.start-b.start);
            int ret = 0, preEnd = intervals[0].end;
            for(int i=1;i<intervals.length;i++){
                if(intervals[i].start >= preEnd) preEnd = intervals[i].end;
                else {
                    ret++;
                    preEnd= Math.min(preEnd, intervals[i].end);
                }
            }
            return ret;
        }
    }
}
