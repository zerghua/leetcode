package leetcode;

/**
 * Created by Hua on 7/14/2017.

 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Different from the previous question where weight is increasing from root to leaf, now the weight is defined
 from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

 Example 2:
 Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

 */

import leetcode.N0_data_strcture.*;
import java.util.*;
public class N364_NestedListWeightSumII {
    // Linkedin (Premium)
    // 27 / 27 test cases passed.
    // 6 ms
    // find max depth first and then the same solution as N339. Nested List Weight Sum
    public class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int max = findMaxDepth(nestedList);  // find max depth
            return dfs(nestedList, max);
        }

        public int findMaxDepth(List<NestedInteger> nestedList){
            int max = 0, cur = 1;
            for(NestedInteger ni : nestedList){
                if(!ni.isInteger()) cur = 1 + findMaxDepth(ni.getList());
                max = Math.max(max, cur);
            }
            return max;
        }

        public int dfs(List<NestedInteger> nestedList, int level){
            int sum = 0;
            for(NestedInteger ni : nestedList){
                if(ni.isInteger()) sum += ni.getInteger() * level;
                else sum += dfs(ni.getList(), level-1);
            }
            return sum;
        }
    }


    // another interesting solution
    // 27 / 27 test cases passed.
    // 4 ms
    public class Solution2 {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int unweighted = 0, weighted = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for (NestedInteger ni : nestedList) {
                    if (ni.isInteger())
                        unweighted += ni.getInteger();
                    else
                        nextLevel.addAll(ni.getList());
                }
                weighted += unweighted;
                nestedList = nextLevel;
            }
            return weighted;
        }
    }
}
