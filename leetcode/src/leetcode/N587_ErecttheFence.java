package leetcode;

/**
 * Created by Hua on 6/16/2017.

 There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden.
 Your job is to fence the entire garden using the minimum length of rope as it is expensive.
 The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees
 which are exactly located on the fence perimeter.

 Example 1:

 Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 Explanation:

 Example 2:

 Input: [[1,2],[2,2],[4,2]]
 Output: [[1,2],[2,2],[4,2]]
 Explanation:

 Even you only have trees in a line, you need to use rope to enclose them.

 Note:

 All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them
 in more than one group.

 All input integers will range from 0 to 100.
 The garden has at least one tree.
 All coordinates are distinct.
 Input points have NO order. No order required for output.


 https://en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain


 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N587_ErecttheFence {
    // convex hull problem
    // 82 / 82 test cases passed.
    // 116 ms
    public class Solution {
        public List<Point> outerTrees(Point[] points) {
            Arrays.sort(points, (a, b) -> a.x != b.x ? a.x - b.x : a.y - b.y);
            List<Point> ret = new ArrayList();


            // lower level, left to right
            for(int i=0; i<points.length; i++){
                while(ret.size() > 1 && cross(ret.get(ret.size()-2), ret.get(ret.size()-1), points[i]) < 0) ret.remove(ret.size()-1);
                ret.add(points[i]);
            }

            if(ret.size() == points.length) return ret;  // if all points collinear

            // upper level, right to left
            for(int i= points.length -2; i>=0 ; i--){
                while(ret.size() > 1 && cross(ret.get(ret.size()-2), ret.get(ret.size()-1), points[i]) < 0) ret.remove(ret.size()-1);
                ret.add(points[i]);
            }

            ret.remove(ret.size()-1);
            return ret;
        }

        // 2D cross product of OA and OB vectors, i.e. z-component of their 3D cross product. Returns a positive value,
        // if OAB makes a counter-clockwise turn, negative for clockwise turn, and zero if the points are collinear.
        public int cross(Point o, Point a, Point b){
            return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
        }
    }
}
