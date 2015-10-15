package leetcode;

public class N168_ExcelSheetColumnTitle {
	//0 ms
    public static String convertToTitle(int n) {
    	String ret="";
        while(n>0){
        	n--;
        	int val = n%26;
        	ret = String.valueOf(Character.toChars('A' + val)) + ret;
        	n /=26;
        }
    	return ret;
    }
    
    public static void main(String[] args) {	
    	System.out.println("hua");
    	System.out.println(convertToTitle(1));
    	System.out.println(convertToTitle(26));
    	System.out.println(convertToTitle(27));
    	System.out.println(convertToTitle(28));    	
    	
    }
    
}
