package leetcode;

/**
 * Created by Hua on 7/11/2017.

 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 The cost of painting each house with a certain color is different. You have to paint all the houses such
 that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house
 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 */
public class N256_PaintHouse {
    // linkedin (Premium)
    // 101 / 101 test cases passed.
    // 1 ms
    // simple DP
    public class Solution {
        public int minCost(int[][] costs) {
            if(costs ==null || costs.length ==0) return 0;
            int a = costs[0][0], b = costs[0][1], c = costs[0][2];
            for(int i=1; i<costs.length; i++){
                int new_a = costs[i][0] + Math.min(b, c);
                int new_b = costs[i][1] + Math.min(a, c);
                int new_c = costs[i][2] + Math.min(a, b);
                a = new_a;
                b = new_b;
                c = new_c;
            }
            return Math.min(a, Math.min(b, c));
        }
    }
}
