package leetcode;

import java.util.*;


/**
 * Created by Hua on 3/25/2016.

 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.

 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:

 [
     [7],
     [2, 2, 3]
 ]


 */
public class N39_CombinationSum {
    // Uber, Snapchat
    // backtracking
    // 168 / 168 test cases passed.   9/6/2017
    // 21 ms
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ret = new ArrayList();
            Arrays.sort(candidates);
            dfs(ret, new LinkedList(), candidates, target, 0);
            return ret;
        }

        public void dfs(List<List<Integer>> ret, LinkedList<Integer> list, int[] nums, int target, int start){
            if(target == 0){
                ret.add(new ArrayList(list));
                return;
            }

            for(int i=start; i<nums.length; i++){
                if(target < nums[i]) return;  // pruning
                list.add(nums[i]);
                dfs(ret, list, nums, target - nums[i], i);
                list.removeLast();
            }
        }
    }


    //  7 ms
    public void combinationSum_helper(int[] candidates, int start, int last_sum, int target,
                                      LinkedList<Integer> list, List<List<Integer>> ret){
        for(int i=start;i<candidates.length;i++){
            int current_sum = candidates[i] + last_sum;
            if(current_sum == target) {
                LinkedList<Integer> ret_list = new LinkedList<>();
                for(int e: list) ret_list.add(e);
                ret_list.add(candidates[i]);
                ret.add(ret_list);
                break;
            }

            if(current_sum < target){
                list.add(candidates[i]);
                combinationSum_helper(candidates, i, current_sum,target,list,ret);
                list.removeLast();
            }
        }
    }


    // 6 ms   168 / 168 test cases passed.
    public void combinationSum_helper_better(int[] candidates, int start, int target,
                                      LinkedList<Integer> list, List<List<Integer>> ret){
        if(0 == target) {
            ret.add(new LinkedList<>(list));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(candidates[i] > target) return;
            if(i>start && candidates[i-1] == candidates[i]) continue; // to skip duplicate, OJ missed this test case.
            list.add(candidates[i]);
            combinationSum_helper_better(candidates, i,target-candidates[i],list,ret);
            list.removeLast();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<>();
        if(candidates == null) return ret;

        Arrays.sort(candidates); //for OJ to compare results
        combinationSum_helper_better(candidates, 0, target, list, ret);
        return ret;
    }
}
