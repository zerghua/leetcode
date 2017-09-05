package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

*/
public class N119_PascalsTriangle2 {
	// Amazon
	// version 3 added on 9/13/2016
	// the index starts from 0?
	// rolling array, scan backward.
	// n=0    1
	// n=1    1 1
	// n=2    1 2 1
	// n=3    1 3 3 1
	// 1 ms 34 / 34 test cases passed.
	public class Solution {
		public List<Integer> getRow(int rowIndex) {
			Integer[] row = new Integer[rowIndex+1];
			Arrays.fill(row, 1);
			for(int i=1; i<=rowIndex;i++){
				for(int j= i-1;j >= 1;j--){  // only works if backward
					row[j] += row[j-1];
				}
			}
			return Arrays.asList(row);
		}
	}

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
