package leetcode;

//https://en.wikipedia.org/wiki/Digital_root
//272 ms 60%
public class N258_addDigits {
    public int addDigits(int num) {
    	if(num == 0) return 0;
    	else{
        	int ret = num%9;
        	if(ret ==0 ) return 9;
        	else return ret;    		
    	}
    }
}
