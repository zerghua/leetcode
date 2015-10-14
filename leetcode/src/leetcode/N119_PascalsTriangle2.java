package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class N119_PascalsTriangle2 {
	//4 ms
    public List<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(rowIndex < 0) return list;
    	
    	list.add(1);
    	for(int i=1; i<=rowIndex; i++){
    		int pre =1;
    		for(int j=1;j<i;j++){
    			int new_value = pre + list.get(j);
    			pre = list.get(j);
    			list.set(j, new_value);
    		}
    		list.add(1);
    	}     
    	return list;
    }
    
    //3 ms
    public List<Integer> getRow2(int rowIndex) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(rowIndex < 0) return list;
    	
    	list.add(1);
    	for(int i=1; i<=rowIndex; i++){
    		for(int j=list.size()-2;j>=0;j--){
    			list.set(j+1, list.get(j) + list.get(j+1));
    		}
    		list.add(1);
    	}     
    	return list;
    }    
    
}
