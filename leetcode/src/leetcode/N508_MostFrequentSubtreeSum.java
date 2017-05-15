package leetcode;

/**
 * Created by Hua on 5/15/2017.


 Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is
 the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

    5
  /  \
 2   -3

 return [2, -3, 4], since all the values happen only once, return all of them in any order.

 Examples 2
 Input:

    5
  /  \
 2   -5

 return [2], since 2 happens twice, however -5 only occur once.

 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N508_MostFrequentSubtreeSum {
    // DFS + hashmap, lengthy code
    // 61 / 61 test cases passed.
    // 22 ms
    public class Solution {
        int maxCount = 0;
        public int[] findFrequentTreeSum(TreeNode root) {
            HashMap<Integer, Integer> map = new HashMap();
            dfs(root, map);

            ArrayList<Integer> list = new ArrayList();
            for(int key : map.keySet()){
                if(map.get(key) == maxCount){
                    list.add(key);
                }
            }

            int[] ret = new int[list.size()];
            for(int i=0;i<list.size();i++) ret[i] = list.get(i);
            return ret;
        }

        public int dfs(TreeNode node, HashMap<Integer, Integer> map){
            if(node == null) return 0;

            int left = dfs(node.left, map);
            int right = dfs(node.right, map);
            int sum = left + right + node.val;

            if(!map.containsKey(sum)) map.put(sum, 0);
            map.put(sum, map.get(sum) + 1);

            maxCount = Math.max(maxCount, map.get(sum));
            return sum;
        }
    }



}
