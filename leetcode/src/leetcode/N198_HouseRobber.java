package leetcode;

public class N198_HouseRobber {
	//0 ms
    public int rob(int[] nums) {
        if(nums.length < 1) return 0;
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=nums.length;i++)
        	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
    	
    	return dp[nums.length];
    }
    
    //0 ms
    public int rob2(int[] nums) {
    	if(nums==null || nums.length == 0) return 0;
		int even=0, odd=0;
		for(int i=0;i<nums.length;i++){
			if(i%2 == 0){
				even += nums[i];
				even = Math.max(even, odd);
			}else{
				odd += nums[i];
				odd = Math.max(even, odd);				
			}
		}
		return Math.max(even, odd);
    }    
}
