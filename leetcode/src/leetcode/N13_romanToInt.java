package leetcode;
import java.util.HashMap;

/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */


public class N13_romanToInt {
    // Google, Facebook, Mircosoft
    // 3999 / 3999 test cases passed.  on 8/17/2017
    // 116 ms
    public class Solution {
        public int romanToInt(String s) {
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            hm.put('I', 1);
            hm.put('V', 5);
            hm.put('X', 10);
            hm.put('L', 50);
            hm.put('C', 100);
            hm.put('D', 500);
            hm.put('M', 1000);

            int sum=0;
            for(int i=0;i<s.length() -1 ;i++){
                int c = hm.get(s.charAt(i));
                if(c < hm.get(s.charAt(i+1))) sum -= c;
                else sum+=c;
            }
            sum+= hm.get(s.charAt(s.length()-1));
            return sum;
        }
    }




	// 444 ms ms  75%
	public int romanToInt2(String s) {
		int sum=0;
		for(int i=0;i<s.length() -1 ;i++){
			int c = getRomanInt(s.charAt(i));
			if(c < getRomanInt(s.charAt(i+1))) sum -= c;
			else sum+=c;
		}
		sum+= getRomanInt(s.charAt(s.length()-1));
		return sum;
	}
    
    public int getRomanInt(char c){
    	int ret = 0;
    	switch(c){
    		case 'I': ret =1;break;
    		case 'V': ret =5;break;
    		case 'X': ret =10;break;
    		case 'L': ret =50;break;
    		case 'C': ret =100;break;
    		case 'D': ret =500;break;
    		case 'M': ret =1000;break;
    	}
    	return ret;
    }

}
