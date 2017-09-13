package leetcode;

/**
 * Created by Hua on 7/24/2017.

 A 2d grid map of m rows and n columns is initially filled with water.
 We may perform an addLand operation which turns the water at position (row, col) into a land.
 Given a list of positions to operate, count the number of islands after each addLand operation.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0

 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0

 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0

 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0

 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0

 We return the result as an array: [1, 1, 2, 3]

 Challenge:

 Can you do it in time complexity O(k log mn), where k is the length of the positions?

 */
import java.util.*;
public class N305_NumberofIslandsII {
    // google (Premium)
    // classic union find problem, one key is to transform 2d to 1d, using formula n*x + y
    // 158 / 158 test cases passed.
    // 25 ms(without path compression)
    // 20 ms(with path compression)
    public class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> ret = new LinkedList();
            int[] a = new int[m*n]; // 2d -> 1d
            Arrays.fill(a, -1);
            int count = 0;
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

            for(int[] p : positions){
                int key = n*p[0] + p[1];  // 2d -> 1d
                count++;
                a[key] = key;

                for(int[] dir: dirs){
                    int x = p[0] + dir[0], y = p[1] + dir[1], new_key = x * n + y;
                    if(x < 0 || x >= m || y < 0 || y>= n || a[new_key] == -1) continue;

                    int root = findRoot(a, new_key);
                    if(key != root){
                        a[key] = root;  // set key's parent to root
                        key = root;     // set key as root for next comparison
                        count--;
                    }
                }
                ret.add(count);
            }
            return ret;
        }

        public int findRoot(int[] a, int key){
            while(key != a[key]) {
                a[key] = a[a[key]];    // one line path compression, set grandchildren to be children
                key = a[key];          //go up to parent
            }
            return key;
        }
    }
}
