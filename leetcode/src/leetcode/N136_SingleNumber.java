package leetcode;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class N136_SingleNumber {
    // Airbnb
	//The key to solve this problem is bit manipulation. 
	//XOR will return 1 only on two different bits. 
	//So if two numbers are the same, XOR will return 0. Finally only one number left.
	//1 ms
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i: nums){
        	ret = ret ^ i;
        }
    	return ret;
    }
    
    //solution 2, use hashset, drop element in hashset if another shows up.
}
