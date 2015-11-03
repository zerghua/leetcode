package leetcode;

import java.util.*;

/**
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class N46_Permutations {
    //6 ms 19%
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        List<Integer> nums_arraylist = new ArrayList<>();
        for(int i: nums) nums_arraylist.add(i);
        permute(ret, nums_arraylist, list);
        return ret;

    }

    public List<Integer> deep_copy_list(List<Integer> list){
        List<Integer> new_list = new ArrayList<>();
        for(int i : list) new_list.add(i);
        return new_list;
    }

    public List<Integer> get_list_without_element_i(List<Integer> list, int index){
        List<Integer> new_list = new ArrayList<>();
        for(int i : list) new_list.add(i);
        new_list.remove(index);
        return new_list;
    }

    public void permute(List<List<Integer>> ret, List<Integer> nums, List<Integer> list) {
        if(nums.size() == 1) {
            list.add(nums.get(0));
            ret.add(list);
            return;
        }

        for(int i=0; i<nums.size(); i++){
            List<Integer> new_list = deep_copy_list(list);
            new_list.add(nums.get(i));
            List<Integer> new_nums= get_list_without_element_i(nums, i);
            permute(ret, new_nums, new_list);
        }
    }


/* 2ms, 97%
public List<List<Integer>> permute(int[] num) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	permute(num, 0, result);
	return result;
}

public void permute(int[] num, int start, List<List<Integer>> result) {

	if (start >= num.length) {
		List<Integer> item = convertArrayToList(num);
		result.add(item);
	}

	for (int j = start; j <= num.length - 1; j++) {
		swap(num, start, j);
		permute(num, start + 1, result);
		swap(num, start, j);
	}
}

public List<Integer> convertArrayToList(int[] num) {
	List<Integer> item = new ArrayList<Integer>();
	for (int h = 0; h < num.length; h++) {
		item.add(num[h]);
	}
	return item;
}

public void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}

*/

}
