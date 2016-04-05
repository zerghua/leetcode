package leetcode;

import java.util.*;

/**
 * Created by zhanhua on 3/31/2016.
 */
public class N47_Permutations2 {
    //make ret unique, TLE
    //HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    //hs.addAll(ret);
    //ret.clear();
    //ret.addAll(hs);


    // 6ms
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