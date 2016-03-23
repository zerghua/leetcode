package leetcode;
import java.util.*;
/**
 * Created by Hua on 3/22/2016.
 */


public class N78_Subsets {
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

}
