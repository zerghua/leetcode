package leetcode;
import java.util.*;
/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


 */

public class N118_PascalsTriangle {
	//2 ms
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1));
    	ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(1, 1));
    	if(numRows == 0) return ret;
		ret.add(l1);
		if(numRows == 1) return ret; 	
		ret.add(l2);	
    	if(numRows == 2) return ret;
    	
    	int i=3;
    	while(i<=numRows){
    		List<Integer> up_level = ret.get(i-2);
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		list.add(1);
    		int j=0;
    		while(j<up_level.size()-1){
    			list.add(up_level.get(j) + up_level.get(j+1));
    			j++;
    		}
    		list.add(1);
    		ret.add(list);
    		i++;
    	}
    	return ret;
    }
    
    //2 ms
    public List<List<Integer>> generate2(int numRows) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(numRows == 0) return ret;
    	ArrayList<Integer> pre = new ArrayList<Integer>();
    	pre.add(1);
    	ret.add(pre);

    	for(int i=2; i<=numRows; i++){
    		ArrayList<Integer> cur = new ArrayList<Integer>();
    		cur.add(1);
    		for(int j=0; j< pre.size()-1; j++){
    			cur.add(pre.get(j) + pre.get(j+1));
    		}
    		cur.add(1);
    		ret.add(cur);
    		pre = cur;
    	}
    	return ret;
    }


    // version 3 added on 9/13/2016
    // 1 ms 15 / 15 test cases passed.
    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            if(numRows <= 0 ) return ret;
            ret.add(new ArrayList<>(Arrays.asList(1)));
            while(numRows-- > 1){
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1));
                List<Integer> pre_list = ret.get(ret.size()-1);
                int size =pre_list.size();
                for(int i=0;i<size-1;i++){
                    list.add(pre_list.get(i)+ pre_list.get(i+1));
                }
                list.add(1);
                ret.add(list);
            }
            return ret;
        }
    }
}
