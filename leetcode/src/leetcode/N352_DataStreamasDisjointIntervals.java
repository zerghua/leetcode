package leetcode;

/**
 * Created by Hua on 5/24/2017.

 Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]

 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

 */

import java.util.*;
public class N352_DataStreamasDisjointIntervals {
    // no company
    // very interesting problem using treemap(sorted hashmap, log(n) operation on add, remove, insert, search)
    // 9 / 9 test cases passed.
    // 203 ms
    public class SummaryRanges {
        TreeMap<Integer, Interval> map ;  // key is the start of each interval

        /** Initialize your data structure here. */
        public SummaryRanges() {
            map = new TreeMap();
        }

        public void addNum(int val) {
            if(map.containsKey(val)) return;
            Integer l = map.lowerKey(val);
            Integer h = map.higherKey(val);

            if(l != null && h != null && map.get(l).end + 1 == val && val + 1 == h){ // merge interval
                map.get(l).end = map.get(h).end;
                map.remove(h);
            }
            else if(l != null && val <= map.get(l).end + 1){ // val inside an interval
                map.get(l).end = Math.max(map.get(l).end, val);
            }
            else if(h != null && val + 1 == h){ // val is 1 step ahead of h start
                map.put(val, new Interval(val, map.get(h).end));
                map.remove(h);
            }
            else map.put(val, new Interval(val, val));
        }

        public List<Interval> getIntervals() {
            return new LinkedList<>(map.values());
        }
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
