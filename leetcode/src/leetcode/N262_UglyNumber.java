package leetcode;


public class N262_UglyNumber {
	public int getRemain(int num, int divisor){
		while (num%divisor ==0){
			num = num/divisor;
		}
		return num;
	}
	
	//312 ms 13%
    public boolean isUgly(int num) {
    	if (num<=0) return false;
        int n = getRemain(num, 5);
        n = getRemain(n, 3);
        n = getRemain(n, 2);
        System.out.println(n);
    	return n==1;
    }
    
    //236 ms 95%
    public boolean isUgly2(int num) {
    	if (num<=0) return false;
        while(num%5 ==0) num/=5;
        while(num%3 ==0) num/=3;
        while(num%2 ==0) num/=2;
    	return num==1;
    }    
    
    public static void main(String[] args){
    	N262_UglyNumber s = new N262_UglyNumber();
    	System.out.println(s.isUgly(23232323));
    }
}
