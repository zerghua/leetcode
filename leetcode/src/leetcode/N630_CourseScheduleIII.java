package leetcode;

/**
 * Created by Hua on 6/30/2017.

 There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and
 closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day.
 You will start at the 1st day.


 Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.

 Example:

 Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 Output: 3
 Explanation:
 There're totally 4 courses, but you can take 3 courses at most:
 First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take
 the next course on the 101st day.

 Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take
 the next course on the 1101st day.

 Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

 Note:

 The integer 1 <= d, t, n <= 10,000.
 You can't take two courses simultaneously.


 */

import java.util.*;
public class N630_CourseScheduleIII {
    // sort by deadline and max heap by duration. greedy
    // 95 / 95 test cases passed.
    // 224 ms 
    public class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a,b) -> a[1] - b[1]); // sort by deadline
            int time = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> b - a); // sort by duration
            for(int[] a : courses){
                time += a[0];
                heap.add(a[0]);
                if(time > a[1]) time -= heap.poll(); // remove the one has the longest duration
            }
            return heap.size();
        }
    }

}
