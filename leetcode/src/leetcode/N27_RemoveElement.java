package leetcode;

public class N27_RemoveElement {
	
	//276 ms 76%
    public int removeElement(int[] nums, int val) {
    	int count=0;
    	for(int i=0;i<nums.length;i++)
    		if(nums[i] ==val) count++;

        int l=0,r=nums.length-1;
    	while(l < r){
    		if(nums[l] == val) {
    			while(nums[r] == val && r>0) r--;

    			nums[l] = nums[r];
    			r--;
    		}
    		l++;
    	}
    	return nums.length - count;
    }
    
    //268 ms  85%
    public int removeElement2(int[] nums, int val) {
        int i=0, j=0;
        while(j < nums.length){
            if(nums[j] != val){
            	nums[i] = nums[j];
                i++; 
            }
            j++;
        }
        return i;
    }    
    
    //288 ms  58%
    public int removeElement3(int[] nums, int val) {
        int l=0,r=nums.length-1;
    	while(l <= r){
    		if(nums[l] == val) {
    			nums[l] = nums[r];
    			r--;
    			continue;
    		}
    		l++;
    	}
    	return r+1;
    }
}
