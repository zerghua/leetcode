package leetcode;

//fibonacci sequence
public class N70_climbStairs {
	
	// 208 ms  62%
    public int climbStairs(int n) {
    	if (n<3) return n;
    	int[] a = {1,2};
    	for(int i=3;i<=n;i++){
    		int c = a[0] + a[1];
    		a[0] = a[1];
    		a[1] = c; 
    	}
    	return a[1];
    }
    
    //196 ms  79%
    public int climbStairs2(int n) {
    	if (n == 0) return 0;
    	int a=1, b=1;
    	for(int i=2;i<=n;i++){
			int c= a+b;
			a= b;
			b= c;
    	}
    	return b;
    }
        
    
}
