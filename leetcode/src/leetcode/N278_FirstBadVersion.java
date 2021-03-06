package leetcode;

/*
 You are a product manager and currently leading a team to develop a new product.
 Unfortunately, the latest version of your product fails the quality check.
 Since each version is developed based on the previous version, all the versions
 after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.

 */

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */


public class N278_FirstBadVersion {
    public class VersionControl{
        boolean isBadVersion(int version){return false;}
    }

    // Facebook
    // simple binary search
    // 21 / 21 test cases passed.  on 8/15/2017
    // 19 ms
	public class Solution extends VersionControl {
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
}
