package leetcode;
/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */


public class N278_FirstBadVersion {
	boolean isBadVersion(int version){return false;}
	
	//21 ms
    public int firstBadVersion(int n) {
    	int i=1, j=n, ret=1;
    	while(i<=j){
    		int mid = (j-i)/2 + i;
    		if(isBadVersion(mid)) {//continue look for the first bad one
    			ret = mid;
    			j = mid - 1;	
    		}else i=mid+1;
    		
    	}
        return ret;
    }

}
