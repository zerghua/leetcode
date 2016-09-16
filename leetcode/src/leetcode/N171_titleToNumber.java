package leetcode;
/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

 */

// base 26 to base 10
public class N171_titleToNumber {
	//376 ms 20%
    public int titleToNumber(String s) {
    	int sum=0;
    	for(int i=s.length()-1; i>=0; i--){
    		sum += (int)Math.pow(26, s.length()-i-1) * (s.charAt(i)- 'A' + 1);
    	}
    	return sum;
    }
    
    //316 ms 85%
    public int titleToNumber2(String s) {
    	int sum=0;
    	for(int i=0; i< s.length(); i++){
    		sum = sum *26 + (s.charAt(i)- 'A' + 1);
    	}
    	return sum;
    }    
}
