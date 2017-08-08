package leetcode;

import java.util.HashSet;

/*
A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the 
squares of its digits, and repeat the process until the number 
equals 1 (where it will stay), or it loops endlessly in a cycle
which does not include 1. Those numbers for which this process 
ends in 1 are happy numbers.


*/
public class N202_HappyNumber {
	// Uber, Airbnb
	//232 ms   86%
	public int getHappy(int n){
		int ret=0;
		String s = String.valueOf(n);
		for(int i=0;i<s.length();i++){
			ret += Math.pow((Character.getNumericValue(s.charAt(i))), 2);
		}
		return ret; 
	}
	
	//let's try modulo, very slow,  316 ms  10%
	public int getHappy2(int n){
		int ret=0;
		while(n !=0){
			ret += Math.pow(n%10,2);
			n=n/10;
		}
		return ret;
	}	
	
    public boolean isHappy(int n) {
    	HashSet<Integer> hs = new HashSet<Integer>();
    	while(n>1 && !hs.contains(n)){
    		hs.add(n);
    		n = getHappy(n);	
    	}
    	return 1 == n; 
    }
    
    public static void main(String[] args) {
    	N202_HappyNumber s = new N202_HappyNumber();
    	System.out.println(s.isHappy(7));
    }
    	
    
}
