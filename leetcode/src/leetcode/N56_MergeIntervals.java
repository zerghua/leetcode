package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/28/2016.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 *
 */
public class N56_MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    //15 ms
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if(intervals == null || intervals.size() < 1) return ret;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });

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
