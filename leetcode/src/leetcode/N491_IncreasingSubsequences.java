package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/16/2017.

 Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 and the length of an increasing subsequence should be at least 2 .

 Example:

 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

 Note:

 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of
 increasing sequence.

 */
public class N491_IncreasingSubsequences {
    // Yahoo
    // DFS + backtracking
    // 57 / 57 test cases passed.
    // 57 ms
    // use set of list to remove duplicate. important
    public class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            Set<List<Integer>> ret = new HashSet();
            dfs(nums, 0, ret, new ArrayList<Integer>());
            return new ArrayList(ret);
        }

        public void dfs(int[] nums, int start, Set<List<Integer>> ret, ArrayList<Integer> list){
            if(list.size() >= 2)ret.add(new ArrayList(list));

            for(int i=start; i<nums.length;i++){
                if(list.isEmpty() || nums[i] >= list.get(list.size()-1)){
                    list.add(nums[i]);
                    dfs(nums, i+1, ret, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    // correct, but TLE
    public class Solution_first_attempt {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> ret = new ArrayList();
            dfs(nums, 0, ret, new ArrayList<Integer>());
            return ret;
        }

        public void dfs(int[] nums, int start, List<List<Integer>> ret, ArrayList<Integer> list){
            for(int i=start; i<nums.length;i++){
                boolean isAdded = false;
                if(list.isEmpty() || nums[i] >= list.get(list.size()-1)){
                    isAdded = true;
                    list.add(nums[i]);
                }
                if(list.size() >= 2 && !ret.contains(list))ret.add(new ArrayList(list));
                dfs(nums, i+1, ret, list);
                if(isAdded) list.remove(list.size()-1);
            }
        }
    }



}
