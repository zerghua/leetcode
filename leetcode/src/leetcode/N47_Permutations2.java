package leetcode;

import java.util.*;

/**
 * Created by Hua on 3/31/2016.

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:

 [
     [1,1,2],
     [1,2,1],
     [2,1,1]
 ]

 */
public class N47_Permutations2 {
    //make ret unique, TLE
    //HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    //hs.addAll(ret);
    //ret.clear();
    //ret.addAll(hs);

    // Microsoft, Linkedin
    // 6ms
    // DFS + backtracking with boolean array to store visited node
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length==0) return ret;

        LinkedList<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums, used, ret, list);
        return ret;
     }

    private void permute(int[] nums, boolean[] used, List<List<Integer>> ret, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            ret.add(new LinkedList<Integer>(list));
            return ;
        }

        for(int i=0; i< nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1])continue; //skip duplicate e.g: [1,1,2], skip the second 1

            used[i] = true;
            list.add(nums[i]);
            permute(nums, used, ret, list);
            list.removeLast();
            used[i] = false;
        }
    }

}
