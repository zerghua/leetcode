package leetcode;
public class N88_MergeSortedArray {
	//0 ms
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (n+m >= 2){
	        int x = m+n-1;
	        m--;n--;
	        while(m>=0 && n>=0){
	        	if(nums1[m] > nums2[n]) {
	        		nums1[x] = nums1[m];
	        		m--;
	        	}else {
	        		nums1[x] = nums2[n];
	        		n--;        		
	        	}
	        	x--;
	        }
	    	while(n>=0) {
	    		nums1[x] = nums2[n];
	    		x--; n--;
	    	}
    	}else if (n==1){
    		nums1[0] = nums2[0];
    	}
    }
    
    // 0 ms
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 && n>0){
        	if(nums1[m-1] > nums2[n-1]) {
        		nums1[m+n-1] = nums1[m-1];
        		m--;
        	}else {
        		nums1[m+n-1] = nums2[n-1];
        		n--;        		
        	}
        }
        
    	while(n>0) {
    		nums1[m+n-1] = nums2[n-1];
    		n--;
    	}
    }
}
