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


Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.


 */
public class N125_ValidPalindrome {
	// Microsoft, Facebook
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

    // added on 10/4/2016
    // 12 ms  476 / 476 test cases passed.
    // ask if empty string is palindrome.
	public class Solution {
		public boolean isPalindrome(String s) {
            int i=0, j=s.length()-1;
            char[] a = s.toLowerCase().toCharArray();
            while(i<j){
                while(i<j && !Character.isLetterOrDigit(a[i]))i++;
                while(i<j && !Character.isLetterOrDigit(a[j]))j--;
                if(i<j && a[i] != a[j]) return false;
                i++;j--;
            }
		    return true;
		}
	}
}
