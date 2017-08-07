package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 3/20/2016.

 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
 ]


 */
public class N77_Combinations {
    // no company
    public void combine(LinkedList<Integer> list, int k, List<List<Integer>> ret,
                        LinkedList<Integer> ret_list, int start){
        if(k== ret_list.size()) {
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            for(int e: ret_list) tmp.add(e);
            ret.add(tmp);
            return;
        }

        for(int i=start;i<list.size(); i++){
            ret_list.add(list.get(i));
            combine(list, k, ret, ret_list, i+1);
            ret_list.removeLast();
        }
    }
    // version 1
    public List<List<Integer>> combine(int n, int k) {
        // contruct 1 to n numbers
        LinkedList<Integer> list_of_numbers = new LinkedList<Integer>();
        for(int i=1; i<=n;i++) list_of_numbers.add(i);

        //recursion to find combination
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> ret_list= new LinkedList<Integer>();
        combine(list_of_numbers,k,ret, ret_list, 0);

        return ret;
    }

    // version 2, no need of list_of_numbers array. added on 9/6/2016
    // 80 ms  27 / 27 test cases passed.
    // DFS + backtracking. similar to permutation and subset problem.
    public class Solution {
        public void dfs(List<List<Integer>> ret, int n, int k, ArrayList<Integer> cur_list, int start){
            if(cur_list.size() == k){
                ret.add(new ArrayList<>(cur_list));
                return;
            }

            for(int i=start; i<=n; i++){
                cur_list.add(i);
                dfs(ret, n, k, cur_list, i+1);
                cur_list.remove(cur_list.size()-1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new ArrayList<>();
            dfs(ret, n, k, new ArrayList<>(), 1);
            return ret;
        }
    }

}
