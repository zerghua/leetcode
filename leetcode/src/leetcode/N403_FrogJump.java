package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Hua on 6/1/2017.

 A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
 The frog can jump on a stone, but it must not jump into the water.

 Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the
 river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

 If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog
 can only jump in the forward direction.

 Note:

 The number of stones is ≥ 2 and is < 1,100.
 Each stone's position will be a non-negative integer < 231.
 The first stone's position is always 0.

 Example 1:

 [0,1,3,5,6,8,12,17]

 There are a total of 8 stones.
 The first stone at the 0th unit, second stone at the 1st unit,
 third stone at the 3rd unit, and so on...
 The last stone at the 17th unit.

 Return true. The frog can jump to the last stone by jumping
 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 2 units to the 4th stone, then 3 units to the 6th stone,
 4 units to the 7th stone, and 5 units to the 8th stone.

 Example 2:

 [0,1,2,3,4,8,9,11]

 Return false. There is no way to jump to the last stone as
 the gap between the 5th and 6th stone is too large.

 */
public class N403_FrogJump {
    // TLE DFS
    public class Solution_TLE_DFS {
        public boolean canCross(int[] stones) {
            if(stones[1] > 1) return false;
            return dfs(stones, 1, 1);
        }

        public boolean dfs(int[] a, int i, int step){
            if(i == a.length-1) return true;
            boolean ret = false;
            for(int j = i+1; j<a.length; j++){
                if(a[j] >= a[i] + step -1 && a[j] <= a[i] + step + 1){
                    ret = ret || dfs(a, j, a[j] - a[i]);
                }
            }
            return ret;
        }
    }


    // Hashtable, tricky solution, it's position NOT index. kind of DP.
    // 39 / 39 test cases passed.
    // 110 ms
    public class Solution {
        public boolean canCross(int[] stones) {
            HashMap<Integer, HashSet<Integer>> map = new HashMap();
            for(int i=0; i<stones.length; i++){
                map.put(stones[i], new HashSet());
            }
            map.get(0).add(1);

            for(int i= 0; i<stones.length-1; i++){
                int pos = stones[i];
                for(int jumpSteps : map.get(pos)){
                    if(pos + jumpSteps == stones[stones.length-1]) return true;

                    // add pos can reach from pos + jumpSteps
                    HashSet<Integer> set = map.get(pos + jumpSteps);
                    if(set != null){
                        set.add(jumpSteps + 1);
                        set.add(jumpSteps);
                        if(jumpSteps -1 > 0) set.add(jumpSteps-1);
                    }
                }
            }
            return false;
        }
    }
}
