package leetcode;

import java.util.*;

/**
 * Created by Hua on 3/24/2016.

 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
 ]


 */
public class N90_Subsets2 {
    // Facebook
    // version 1
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        HashSet<List<Integer>> hs = new HashSet<>();

        LinkedList<Integer> list = new LinkedList<>();
        ret.add(list);

        if(nums == null) return ret;

        //for OJ to compare results
        Arrays.sort(nums);

        for(int i=0; i< nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {

                // copy each item in list to a new one
                LinkedList<Integer> new_list = new LinkedList<>();
                for (Integer t : ret.get(j)) {
                    new_list.add(t);
                }

                // add a new item to list
                new_list.add(nums[i]);

                //to solve duplicate issues
                if(!hs.contains(new_list)) {
                    ret.add(new_list);
                    hs.add(new_list);
                }
            }
        }

        return ret;
    }



    public void subsets2_backtracking_helper(int[] nums, int start,
                                             LinkedList<Integer> list,
                                             List<List<Integer>> ret) {
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1])continue; // to skip duplicate
            list.add(nums[i]);

            // in Java needs to have a new list
            LinkedList<Integer> ret_list = new LinkedList<>();
            for(int e: list) ret_list.add(e);

            ret.add(ret_list);
            subsets2_backtracking_helper(nums, i+1, list, ret);
            list.removeLast();
        }
    }

    // version 2
    public List<List<Integer>> subsets2_backtracking(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<>();
        ret.add(list);
        if(nums == null) return ret;

        Arrays.sort(nums); //for OJ to compare results
        subsets2_backtracking_helper(nums, 0, list, ret);
        return ret;
    }


    // version 3 adde on 9/6/2016
    // 4 ms  19 / 19 test cases passed.
    // DFS + backtracking. skip duplicate when i>start && nums[i-1] == nums[i]
    public class Solution {
        public void dfs(List<List<Integer>> ret, int[] nums, List<Integer> cur_list, int start){
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i] == nums[i-1])continue; // to skip duplicate
                cur_list.add(nums[i]);
                ret.add(new ArrayList<>(cur_list));
                dfs(ret, nums, cur_list, i+1);
                cur_list.remove(cur_list.size()-1);
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<Integer> cur_list = new ArrayList<>();
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(cur_list);
            if (nums == null || nums.length == 0) return ret;
            Arrays.sort(nums);
            dfs(ret, nums, cur_list, 0);
            return ret;
        }
    }


}
