package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 3/24/2016.
 */
public class N90_Subsets2 {
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


    public List<List<Integer>> subsets2_backtracking(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<>();
        ret.add(list);
        if(nums == null) return ret;

        Arrays.sort(nums); //for OJ to compare results
        subsets2_backtracking_helper(nums, 0, list, ret);
        return ret;
    }
}
