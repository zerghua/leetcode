package leetcode;

import java.util.Arrays;

/**
 * Created by HuaZ on 12/14/2016.

 Winter is coming! Your first job during the contest is to design a standard heater with fixed
 warm radius to warm all the houses.

 Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius
 of heaters so that all houses could be covered by those heaters.

 So, your input will be the positions of houses and heaters seperately, and your expected output will be
 the minimum radius standard of heaters.

 Note:

 Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 As long as a house is in the heaters' warm radius range, it can be warmed.
 All the heaters follow your radius standard and the warm radius will the same.

 Example 1:

 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard,
 then all the houses can be warmed.

 Example 2:

 Input: [1,2,3,4],[1,4]
 Output: 1
 Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard,
 then all the houses can be warmed.


 */
public class N475_Heaters {
    // find the nearest heater for each house, by comparing the next heater with the current heater.
    // tricky
    // time o(nlogn)
    // advance to next heater when the next one is closer to current house.
    // 28 ms 27 / 27 test cases passed.
    public class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int ret =0, i=0;
            Arrays.sort(houses);
            Arrays.sort(heaters);
            for(int house: houses){
                while(i<heaters.length-1 &&
                      Math.abs(heaters[i+1] - house) <= Math.abs(heaters[i] - house) ) i++;
                ret = Math.max(ret, Math.abs(heaters[i] - house));
            }
            return ret;
        }
    }
}
