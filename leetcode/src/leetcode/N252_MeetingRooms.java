package leetcode;

/**
 * Created by HuaZ on 10/23/2016.

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.

 For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */

import leetcode.N0_data_strcture.*;
import java.util.Arrays;

public class N252_MeetingRooms {
    // Facebook (Premium)
    // time o(nlogn) bounded by sort, space o(1)
    // 76 / 76 test cases passed.
    // 14 ms
    public class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            if(intervals == null || intervals.length <=1) return true;
            Arrays.sort(intervals, (Interval a, Interval b) -> a.start-b.start);
            for(int i=1;i<intervals.length;i++){
                if(intervals[i].start < intervals[i-1].end) return false;
            }
            return true;
        }
    }

}
