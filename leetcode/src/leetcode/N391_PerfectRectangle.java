package leetcode;

import java.util.HashSet;

/**
 * Created by Hua on 6/7/2017.

 Given N axis-aligned rectangles where N > 0,
 determine if they all together form an exact cover of a rectangular region.

 Each rectangle is represented as a bottom-left point and a top-right point.
 For example, a unit square is represented as [1,1,2,2].
 (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

 Example 1:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [3,2,4,4],
 [1,3,2,4],
 [2,3,3,4]
 ]

 Return true. All 5 rectangles together form an exact cover of a rectangular region.

 Example 2:

 rectangles = [
 [1,1,2,3],
 [1,3,2,4],
 [3,1,4,2],
 [3,2,4,4]
 ]

 Return false. Because there is a gap between the two rectangular regions.

 Example 3:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [3,2,4,4]
 ]

 Return false. Because there is a gap in the top center.

 Example 4:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [2,2,4,4]
 ]

 Return false. Because two of the rectangles overlap with each other.


 The right answer must satisfy two conditions:

     1. the large rectangle area should be equal to the sum of small rectangles
     2. count of all the points should be even, and that of all the four corner points should exist once

 */
public class N391_PerfectRectangle {
    // Google
    // hard on generalize the two conditions.
    // 46 / 46 test cases passed.
    // 116 ms
    public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            if(rectangles == null || rectangles.length == 0) return false;

            int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
            int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
            HashSet<String> set = new HashSet();
            int area = 0;

            for(int[] ret: rectangles){
                x1 = Math.min(x1, ret[0]);
                y1 = Math.min(y1, ret[1]);
                x2 = Math.max(x2, ret[2]);
                y2 = Math.max(y2, ret[3]);

                area += (ret[2] - ret[0]) * (ret[3] - ret[1]);

                String p1 = ret[0] + " " + ret[1];
                String p2 = ret[0] + " " + ret[3];
                String p3 = ret[2] + " " + ret[1];
                String p4 = ret[2] + " " + ret[3];

                if(!set.add(p1)) set.remove(p1); // 1 line code, or needs two lines
                if(!set.add(p2)) set.remove(p2); // if not contains then add, else remove
                if(!set.add(p3)) set.remove(p3);
                if(!set.add(p4)) set.remove(p4);
            }
            if(!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) ||
                    !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4)
                return false;

            return area == (y2-y1)*(x2-x1);
        }
    }

}
