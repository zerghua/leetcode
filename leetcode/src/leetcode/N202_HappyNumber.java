package leetcode;

import java.util.HashSet;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits, and repeat the process until
the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.


Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1



*/
public class N202_HappyNumber {
	// Uber, Airbnb
    // hashset<int> to store visited number
    // 401 / 401 test cases passed.  on 9/7/2017
    // 6 ms
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> hs = new HashSet<Integer>();
            while(n>1 && !hs.contains(n)){
                hs.add(n);
                n = getHappy(n);
            }
            return 1 == n;
        }

        public int getHappy(int n){
            int ret=0;
            while(n !=0){
                ret += Math.pow(n%10,2);
                n=n/10;
            }
            return ret;
        }
    }



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

    
    public static void main(String[] args) {
    	N202_HappyNumber s = new N202_HappyNumber();
    	//System.out.println(s.isHappy(7));
    }
    	
    
}
