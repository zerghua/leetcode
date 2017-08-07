package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/30/2016.
 *
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class N57_InsertInterval {
    // Google, Facebook
    // 4 ms
    // insert into sorted list first
    // then merge them as N56
    public class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        if(intervals == null || intervals.size() < 1) {
            ret.add(newInterval);
            return ret;
        }

        //insert into sorted list
        boolean isInserted =false;
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start < intervals.get(i).start){
                intervals.add(i,newInterval);
                isInserted = true;
                break;
            }
        }
        if(!isInserted) intervals.add(newInterval);

        //merge sorted intervals as N56
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i<intervals.size();i++){
            if(end < intervals.get(i).start ){
                ret.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }else if(end < intervals.get(i).end){
                end = intervals.get(i).end;
            } //else  end > intervals, do nothing
        }
        ret.add(new Interval(start, end));

        return ret;
    }
}
