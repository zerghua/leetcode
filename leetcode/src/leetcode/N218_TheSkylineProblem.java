package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/7/2017.

 A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from
 a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape
 photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings Skyline Contour

 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
 and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as:
 [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .


 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment.
 Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline,
 and always has zero height.
 Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.


 For instance, the skyline in Figure B should be represented as:
 [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline.
 For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable;
 the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

 */
public class N218_TheSkylineProblem {
    // hard on understanding the problem definition and put it into code
    // the key is to find top left of each rectangle and return the proper ones + bottom rightmost corner.
    // 36 / 36 test cases passed.
    // 404 ms
    public class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> h = new ArrayList();  // each building is decomposed as two (x,y)
            for(int[] b: buildings){
                h.add(new int[]{b[0], -b[2]});  // left  x is negative height, this is a trick.
                h.add(new int[]{b[1], b[2]});   // right x is positive height
            }

            // important to avoid return extra ret when two points have the same height. example: [0,2,3] and [2,5,3].
            Collections.sort(h, (a,b) -> (a[0] == b[0])? a[1] - b[1] : a[0] - b[0]);

            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            heap.add(0);

            List<int[]> ret = new ArrayList<>();
            int preHeight = 0;
            for(int[] a: h){
                if(a[1] < 0) heap.add(-a[1]);  // add left corner, problem definition
                else heap.remove(a[1]);

                if(heap.peek() != preHeight) ret.add(new int[]{a[0], heap.peek()});
                preHeight = heap.peek();
            }
            return ret;
        }
    }
}
