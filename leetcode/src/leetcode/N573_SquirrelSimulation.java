package leetcode;

/**
 * Created by Hua on 7/14/2017.

 There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid.
 Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under
 the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions -
 up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.

 Example 1:

 Input:
 Height : 5
 Width : 7
 Tree position : [2,2]
 Squirrel : [4,4]
 Nuts : [[3,0], [2,5]]
 Output: 12
 Explanation:

 Note:

 All given positions won't overlap.
 The squirrel can take at most one nut at one time.
 The given positions of nuts have no order.
 Height and width are positive integers. 3 <= height * width <= 10,000.
 The given positions contain at least one nut, only one tree and one squirrel.

 */
public class N573_SquirrelSimulation {
    // Square (Premium)
    // 122 / 122 test cases passed.
    // 16 ms
    // it only matters on the first travel from squirrel to nut
    public class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int ret = 0, diff= Integer.MIN_VALUE; // min_value is important here, it can be negative.
            for(int[] nut : nuts) {
                diff = Math.max(diff, getDistance(nut, tree) - getDistance(nut, squirrel));
                ret += getDistance(nut, tree) *2;
            }
            return  ret - diff;
        }

        public int getDistance(int[] a, int[] b){
            return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        }
    }

}
