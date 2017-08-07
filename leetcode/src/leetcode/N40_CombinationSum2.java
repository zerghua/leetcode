package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 3/25/2016.

 Given a collection of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.

 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:

 [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
 ]


 */
public class N40_CombinationSum2 {
    // snapchat
    // 172 / 172 test cases passed.
    // 16 ms
    public class Solution {
        public void combinationSum_helper_better(int[] candidates, int start, int target,
                                                 LinkedList<Integer> list, List<List<Integer>> ret){
            if(0 == target) {
                ret.add(new LinkedList<>(list));
                return;
            }

            for(int i=start;i<candidates.length;i++){
                if(candidates[i] > target) return;
                if(i>start && candidates[i]==candidates[i-1]) continue; // remove duplicate

                list.add(candidates[i]);
                combinationSum_helper_better(candidates, i+1, target-candidates[i],list,ret);
                list.removeLast();
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ret = new LinkedList<List<Integer>>();
            LinkedList<Integer> list = new LinkedList<>();
            if(candidates == null) return ret;

            Arrays.sort(candidates); //for OJ to compare results
            combinationSum_helper_better(candidates, 0, target, list, ret);

            return ret;
        }
    }

}
