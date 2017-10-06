package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 8/12/2017.

 You are given an integer array sorted in ascending order (may contain duplicates),
 you need to split them into several subsequences, where each subsequences consist of
 at least 3 consecutive integers. Return whether you can make such a split.

 Example 1:

 Input: [1,2,3,3,4,5]
 Output: True
 Explanation:
 You can split them into two consecutive subsequences :
 1, 2, 3
 3, 4, 5

 Example 2:

 Input: [1,2,3,3,4,4,5,5]
 Output: True
 Explanation:
 You can split them into two consecutive subsequences :
 1, 2, 3, 4, 5
 3, 4, 5

 Example 3:

 Input: [1,2,3,4,4,5]
 Output: False

 Note:

 The length of the input is in range of [1, 10000]


 adapted by C++ code of cchao:

 class Solution {
     public:
     bool isPossible(vector<int>& nums) {
         map<int, priority_queue<int, vector<int>, greater<int>> > m;
         for (int x : nums) {
             int y = 1;
             if (m[x - 1].size()) {
                 y += m[x - 1].top();
                 m[x - 1].pop();
             }
             m[x].push(y);
         }
         for (auto it : m) {
            if (it.second.size() && it.second.top() < 3) return false;
         }
     return true;
     }
 };

 [1,2,3,3,4,4,5,5]


 We iterate through the array once to get the frequency of all the elements in the array

 We iterate through the array once more and for each element we either see if it can be appended
 to a previously constructed consecutive sequence or if it can be the start of a new consecutive sequence.
 If neither are true, then we return false.


 */
public class N659_SplitArrayintoConsecutiveSubsequences {
    // hashmap + greedy
    // o(n) solution
    // 180 / 180 test cases passed.  on 10/5/2017
    // 88 ms
    public class Solution{
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>(), tail = new HashMap<>();
            for (int i : nums) count.put(i, count.getOrDefault(i,0) + 1);

            for (int i : nums) {
                if (count.get(i) == 0) continue;
                count.put(i, count.get(i) - 1);

                if (tail.getOrDefault(i,0) > 0) {   // try to previous tail first
                    tail.put(i, tail.get(i) - 1);
                    tail.put(i+1, tail.getOrDefault(i+1,0) + 1);
                }
                else if (count.getOrDefault(i+1,0) > 0 && count.getOrDefault(i+2,0) > 0) { // try to combine next two
                    count.put(i+1, count.get(i+1) - 1);
                    count.put(i+2, count.get(i+2) - 1);
                    tail.put(i+3, tail.getOrDefault(i+3,0) + 1);
                }
                else return false;
            }
            return true;
        }
    }


    // map + priority queue
    // important, the given array is sorted.
    // try to add next to the smallest list
    // 180 / 180 test cases passed.
    // 164 ms
    public class Solution2 {
        public boolean isPossible(int[] nums) {
            HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();
            for(int e : nums){
                int count = 1;
                if(!map.containsKey(e-1)) map.put(e-1, new PriorityQueue());
                if(!map.get(e-1).isEmpty()){
                    count += map.get(e-1).remove();
                }
                if(!map.containsKey(e)) map.put(e, new PriorityQueue());
                map.get(e).add(count);
            }

            for(int i : map.keySet()) {
                if (map.get(i) != null && !map.get(i).isEmpty() && map.get(i).peek() < 3)
                    return false;
            }
            return true;
        }
    }


}
