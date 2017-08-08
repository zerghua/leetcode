package leetcode;
/*
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

    A naive implementation of the above process is trivial. Could you come up with other methods?
    What are all the possible results?
    How do they occur, periodically or randomly?
    You may find this Wikipedia article useful.


 */

public class N258_addDigits {
	// Microsoft, Adobe
	//https://en.wikipedia.org/wiki/Digital_root
	//272 ms 60%
    public int addDigits(int num) {
    	if(num == 0) return 0;
    	else{
        	int ret = num%9;
        	if(ret ==0 ) return 9;
        	else return ret;    		
    	}
    }
}
