package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 11/8/2016.

 Given n points in the plane that are all pairwise distinct,
 a "boomerang" is a tuple of points (i, j, k) such that the distance
 between i and j equals the distance between i and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most
 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Example:

 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]


 */
public class N447_NumberofBoomerangs {
    // hashmap to store calculated distance, reduce o(n^3) to o(n^2)
    // 146 ms 31 / 31 test cases passed.
    public class Solution {
        public int numberOfBoomerangs(int[][] points) {
            HashMap<Integer, Integer> map = new HashMap();
            int ret = 0;
            for(int[] i: points){
                for(int[] j: points){
                    if(i==j) continue; // skip the same point
                    int dist = (int)Math.pow(i[0]-j[0],2) + (int)Math.pow(i[1]-j[1],2);
                    int pre_dist = map.containsKey(dist)? map.get(dist) : 0;
                    ret += pre_dist * 2;
                    map.put(dist, pre_dist+1);
                }
                map.clear();
            }
            return ret;
        }
    }

}
