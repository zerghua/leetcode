package leetcode;

/**
 * Created by Hua on 7/21/2017.

 Given a list of points that form a polygon when joined sequentially,
 find if this polygon is convex (Convex polygon definition).

 Note:

 There are at least 3 and at most 10,000 points.
 Coordinates are in the range -10,000 to 10,000.
 You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other
 words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.

 Example 1:

 [[0,0],[0,1],[1,1],[1,0]]

 Answer: True

 Explanation:

 Example 2:

 [[0,0],[0,10],[10,10],[10,0],[5,5]]

 Answer: False

 Explanation:


 */

import java.util.*;
public class N469_ConvexPolygon {
    // google
    // math
    // 54 / 54 test cases passed.
    // 19 ms
    public class Solution {
        public boolean isConvex(List<List<Integer>> points) {
            boolean isClock = false, isAntiClock = false;
            int n = points.size();
            for(int i=0; i<n; i++){
                int num = slope(points.get(i%n), points.get((i+1)%n), points.get((i+2)%n));
                if(num > 0) isClock = true;
                else if (num < 0) isAntiClock = true;

                if(isClock && isAntiClock) return false;
            }
            return true;
        }

        // the formula comes from: two slopes,  (y2 - y1)/(x2 - x1) and (y3 - y2)/(x3 - x2)
        public int slope(List<Integer> A, List<Integer> B, List<Integer> C){
            int x1 = A.get(0), y1 = A.get(1), x2 = B.get(0), y2 = B.get(1), x3 = C.get(0), y3 = C.get(1);
            return (y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1);
        }
    }

}
