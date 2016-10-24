package leetcode;

/**
 * Created by HuaZ on 10/23/2016.

 Given an array of meeting time intervals consisting of start and end times
 [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.

 */
import leetcode.N0_data_strcture.*;
import java.util.*;

public class N253_MeetingRoomsII {
    // merge interval greedily by using min heap sorted by interval.end
    // example: (1,4) (2,6) (5,9) (8,9)
    // time o(nlogn) bounded by sort
    public class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            if(intervals == null || intervals.length==0) return 0;
            Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
            PriorityQueue<Interval> heap = new PriorityQueue<Interval>((a, b) -> a.end - b.end);//end
            heap.add(intervals[0]);
            for(int i=1;i<intervals.length;i++){
                Interval cur = heap.poll();
                if(intervals[i].start >= cur.end) cur.end = intervals[i].end; //merge into one room
                else heap.add(intervals[i]);  //add new room can't be merged
                heap.add(cur); // remember to add it back.
            }
            return heap.size();
        }
    }
}
