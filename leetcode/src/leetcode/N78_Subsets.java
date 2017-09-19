package leetcode;
import java.util.*;
/**
 * Created by Hua on 3/22/2016.


 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
 ]

 */


public class N78_Subsets {
    // Facebook, Amazon
    // version 4,  on 9/6/2016
    // 3 ms   10 / 10 test cases passed.
    // DFS + backtracking.
    public class Solution {
        public void dfs(List<List<Integer>> ret, int[] nums, List<Integer> cur_list, int start){
            for(int i=start;i<nums.length;i++){
                cur_list.add(nums[i]);
                ret.add(new ArrayList<>(cur_list));
                dfs(ret, nums, cur_list, i+1);
                cur_list.remove(cur_list.size()-1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> cur_list = new ArrayList<>();
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(cur_list);
            if (nums == null || nums.length == 0) return ret;
            dfs(ret, nums, cur_list, 0);
            return ret;
        }
    }









    public void get_subsets(int[] nums, int start,  List<List<Integer>> ret){
        if(start > nums.length-1) return;

        //for list in ret, add one more item to it. will double the size of ret.
        int size = ret.size();
        for(int j=0; j< size; j++){

            // copy each item in list to a new one
            LinkedList<Integer> new_list = new LinkedList<>();
            for(Integer t: ret.get(j)){new_list.add(t);}

            // add a new item to list
            new_list.add(nums[start]);

            ret.add(new_list);
        }

        // add the next item.
        get_subsets(nums, start+1, ret);
    }

    // version 1
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();

        LinkedList<Integer> list = new LinkedList<>();
        ret.add(list);

        if(nums == null) return ret;

        //for OJ to compare results
        Arrays.sort(nums);

        get_subsets(nums, 0, ret);

        return ret;
    }

    // version 2
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();

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

                ret.add(new_list);
            }
        }

        return ret;
    }

    // version 3
    public void subsets3_backtracking_helper(int[] nums, int start,
                                                            LinkedList<Integer> list,
                                                            List<List<Integer>> ret) {
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);

            // in Java needs to have a new list
            LinkedList<Integer> ret_list = new LinkedList<>();
            for(int e: list) ret_list.add(e);

            ret.add(ret_list);
            subsets3_backtracking_helper(nums, i+1, list, ret);
            list.removeLast();
        }
    }


    public List<List<Integer>> subsets3_backtracking(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<>();
        ret.add(list);
        if(nums == null) return ret;

        Arrays.sort(nums); //for OJ to compare results
        subsets3_backtracking_helper(nums, 0, list, ret);
        return ret;
    }

}
