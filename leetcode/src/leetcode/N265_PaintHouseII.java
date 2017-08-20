package leetcode;

/**
 * Created by Hua on 7/26/2017.

 There are a row of n houses, each house can be painted with one of the k colors.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting
 house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?


 test cases:
 [[1,5,3],[2,9,4]]

 */

import java.util.*;
public class N265_PaintHouseII {
    // facebook
    // a more general DP solution similar to 256. Paint House
    // 105 / 105 test cases passed.
    // 64 ms
    // o(n * klogk)
    public class Solution {
        public int minCostII(int[][] costs) {
            if(costs ==null || costs.length ==0) return 0;
            int n = costs.length, k = costs[0].length;
            int[] a = new int[k];
            for(int i=0; i<k;i++) a[i] = costs[0][i];

            for(int i=1; i<n; i++){
                TreeMap<Integer, Integer> map = new TreeMap();
                for(int j=0; j<k; j++){
                    if(!map.containsKey(a[j])) map.put(a[j], 0);
                    map.put(a[j], map.get(a[j]) + 1);
                }

                int[] tmp = new int[k];
                for(int j=0; j<k; j++){
                    map.put(a[j], map.get(a[j]) -1);
                    if(map.get(a[j]) == 0) map.remove(a[j]);

                    tmp[j] = costs[i][j] + map.firstKey();

                    if(!map.containsKey(a[j])) map.put(a[j], 0);
                    map.put(a[j], map.get(a[j]) + 1);
                }
                a = tmp;
            }

            int ret = Integer.MAX_VALUE;
            for(int e : a) ret = Math.min(ret, e);
            return ret;
        }
    }

    /*
        If there's no constraint, we choose min cost for each house.

        Since house[i] and house[i - 1] cannot have the same color j,
        we should choose 2nd min color for house[i - 1].

        If we choose the 3rd min color for house[i - 1], we might miss potential min cost.
        min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.

        Since current row only relies on last row for getting mins and avoiding same color,
        O(1) space is enough.

    */
    // 105 / 105 test cases passed.
    // 4 ms
    public class Solution2 {
        public int minCostII(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            int min1 = 0, min2 = 0, index1 = -1;

            for (int i = 0; i < costs.length; i++) {
                int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;

                for (int j = 0; j < costs[0].length; j++) {
                    int cost = costs[i][j] + (j != index1 ? min1 : min2);

                    if (cost < m1) {           // cost < m1 < m2
                        m2 = m1;
                        m1 = cost;
                        idx1 = j;

                    } else if (cost < m2) {    // m1 < cost < m2
                        m2 = cost;
                    }
                }

                min1 = m1;
                min2 = m2;
                index1 = idx1;
            }
            return min1;
        }
    }
}
