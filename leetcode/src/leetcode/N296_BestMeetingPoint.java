package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 7/23/2017.

 A group of two or more people wants to meet and minimize the total travel distance.
 You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 The distance is calculated using Manhattan Distance,
 where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and (2,2):

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
 So return 6.

 */
public class N296_BestMeetingPoint {
    // twitter
    // math + sort(median will produce the total shortest distance)
    // 57 / 57 test cases passed.
    // 12 ms
    public class Solution {
        public int minTotalDistance(int[][] grid) {
            ArrayList<Integer> l1 = new ArrayList();
            ArrayList<Integer> l2 = new ArrayList();
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 1) {
                        l1.add(i); l2.add(j);
                    }
                }
            }
            return helper(l1) + helper(l2);
        }

        public int helper(ArrayList<Integer> list){
            Collections.sort(list);
            int i=0, j= list.size()-1, ret = 0;
            while(i < j){
                ret += list.get(j) - list.get(i);
                i++; j--;
            }
            return ret;
        }
    }
}
