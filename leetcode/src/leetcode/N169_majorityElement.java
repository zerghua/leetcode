package leetcode;

public class N169_majorityElement {
	
	// 396 ms  81%
    public int majorityElement(int[] nums) {
        int majorElement=nums[0];
        int count=1;
    	for(int i=1;i<nums.length;i++){
    		if(majorElement == nums[i]) count++;
    		else count -- ;
    		
    		if(count == 0) {
    			majorElement = nums[i];
    			count=1;
    		}
    	}
    	return majorElement;
    }
    
    //better coding? the early return sucks
    //608 ms 1%
    public int majorityElement2(int[] nums) {
        int majorElement=0;
        int count=0;
    	for(int i=0;i<nums.length;i++){
    		if(count == 0) {
    			majorElement = nums[i];
    			count=1;
    		}else{
        		if (majorElement == nums[i])count++ ;
        		else count -- ;
    			
        		if(count > nums.length/2) return majorElement;
    		}
    	}
    	return majorElement;
    }    
}
