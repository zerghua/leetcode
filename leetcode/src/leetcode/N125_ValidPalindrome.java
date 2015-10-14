package leetcode;
/*//61 ms
	public static boolean isValidPalindrome(String s){
		if(s==null||s.length()==0) return true;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
 
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
 
		System.out.println(isValidPalindrome(str));
	}
 */
public class N125_ValidPalindrome {
	//7 ms
    public boolean isValidChar(char c){
    	if((c >= 'a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) return true;
    	return false;
    }
	
	public boolean isPalindrome(String s) {
		if(s==null || s.length()==0) return true;
		
        int i=0, j=s.length()-1;
        while(i<j){
        	while(i < s.length() && !isValidChar(s.charAt(i))) i++;
        	while(j > -1 && !isValidChar(s.charAt(j))) j--;
        	
        	if(i<j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
        		return false;
        	i++;j--;
        }
    	return true;
    }
}
