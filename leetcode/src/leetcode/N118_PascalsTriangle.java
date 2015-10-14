package leetcode;
import java.util.*;

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
}
