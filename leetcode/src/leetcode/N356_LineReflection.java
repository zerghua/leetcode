package leetcode;

import java.util.HashSet;

/**
 * Created by HuaZ on 7/22/2017.

 Given n points on a 2D plane, find if there is such a line parallel to y-axis
 that reflect(对称) all the given points.

 Example 1:

 Given points = [[1,1],[-1,1]], return true.

 Example 2:

 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n^2)?

 Hint:

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at x = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.


 */
public class N356_LineReflection {
    // google
    // math all valid pair should == minX + maxX  and set<x + ":" + y>
    // 37 / 37 test cases passed.
    // 21 ms
    public class Solution {
        public boolean isReflected(int[][] points) {
            HashSet<String> set = new HashSet();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int[] p : points){
                min = Math.min(min, p[0]);
                max = Math.max(max, p[0]);
                set.add(p[0] + ":" + p[1]);
            }

            int sum = min + max;
            for(int[] p : points){
                if(!set.contains((sum - p[0]) + ":" + p[1])) return false;
            }
            return true;
        }
    }
}
