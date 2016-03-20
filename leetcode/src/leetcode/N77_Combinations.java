package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 3/20/2016.
 */
public class N77_Combinations {

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

}
