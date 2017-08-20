package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/3/2017.

 There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 The bricks have the same height but different width.
 You want to draw a vertical line from the top to the bottom and cross the least bricks.

 The brick wall is represented by a list of rows.
 Each row is a list of integers representing the width of each brick in this row from left to right.

 If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out
 how to draw the line to cross the least bricks and return the number of crossed bricks.

 You cannot draw a line just along one of the two vertical edges of the wall, in which case the line
 will obviously cross no bricks.

 Example:

 Input:
 [[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
 Output: 2
 Explanation:

 Note:

 The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000].
 Total number of bricks of the wall won't exceed 20,000.

 */
public class N554_BrickWall {
    // Facebook
    // o(n^2) with hashmap
    // find the most common edge
    // hash table
    // 85 / 85 test cases passed.
    // 68 ms
    public class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer, Integer> map = new HashMap();
            int max=0, n = wall.size();
            for(List<Integer> list: wall){
                int length = 0;
                for(int i=0; i< list.size() -1; i++){ //important, need to skip last one
                    length += list.get(i);
                    if(!map.containsKey(length)) map.put(length, 0);
                    map.put(length, map.get(length) + 1);
                    max = Math.max(max, map.get(length));
                }
            }
            return n - max;
        }
    }
}
