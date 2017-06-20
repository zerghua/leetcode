package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Hua on 6/20/2017.

 Given the coordinates of four points in 2D space, return whether the four points could construct a square.

 The coordinate (x,y) of a point is represented by an integer array with two integers.

 Example:

 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 Output: True

 Note:

 All the input integers are in the range [-10000, 10000].
 A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 Input points have no order.


 If we calculate all distances between 4 points, 4 smaller distances should be equal (sides),
 and 2 larger distances should be equal too (diagonals). As an optimization, we can compare squares of the distances,
 so we do not have to deal with the square root and precision loss.

 Therefore, our set will only contain 2 unique distances in case of square (beware of the zero distance though).

 */
public class N593_ValidSquare {
    // math, find pattern to code
    // 244 / 244 test cases passed.
    // 23 ms
    public class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            HashSet<Long> set = new HashSet(Arrays.asList(d(p1, p2), d(p1,p3), d(p1,p4), d(p2,p3), d(p2, p4), d(p3,p4)));
            return set.size() == 2 && !set.contains((long)0); // Java autobox can't convert int to Long.
        }

        // get distance of two points
        public long d(int[] p1, int [] p2){
            return (long)Math.pow(p1[0] - p2[0], 2) + (long)Math.pow(p1[1] - p2[1], 2);
        }
    }
}
