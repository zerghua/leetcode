package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hua on 5/5/2017.

 Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between
 any two time points in the list.

 Example 1:

 Input: ["23:59","00:00"]
 Output: 1

 Note:

 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.

 */
public class N539_MinimumTimeDifference {
    // sort or bucket sort
    // 112 / 112 test cases passed.
    // 51 ms
    public class Solution {
        public int findMinDifference(List<String> timePoints) {
            ArrayList<Integer> list = new ArrayList<>();
            for(String s: timePoints){
                String[] time = s.split(":");
                list.add(Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]));
            }

            Collections.sort(list);

            int min = Integer.MAX_VALUE;
            for(int i = 1; i< list.size(); i++){
                min = Math.min(min, list.get(i) - list.get(i-1));
            }

            return Math.min(min, 1440 - (list.get(list.size()-1) - list.get(0)));
        }
    }
}
