package leetcode;

/**
 * Created by Hua on 5/12/2016.
 *
 *  Given a string S, you are allowed to convert it to a palindrome
 *  by adding characters in front of it. Find and return the shortest palindrome
 *  you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".

 "adcd", return "dcdadcd"

 "acdcd" return "dcdcacdcd"
 */
public class N214_ShortestPalindrome {
    // Google
    //TLE
    public String shortestPalindrome(String s) {
        if(s==null || s.length() <= 1) return s;
        int center_index = 0;
        for(int i=s.length()-1; i>=0;i--){
            if(isPalToLeftEnd(s, i)){
                center_index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=center_index+1; i<s.length();i++) sb.append(s.charAt(i));
        return sb.reverse().toString() + s;
    }

    private boolean isPalToLeftEnd(String s, int index) {
        int left=0;
        int right=index;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


    //memory limit exceed
    public String shortestPalindrome2(String s) {
        if(s==null || s.length() <= 1) return s;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        int index = 0;
        for(int i=s.length()-1; i>=0;i--){
            if(isPal[0][i]){
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index+1; i<s.length();i++) sb.insert(0,s.charAt(i));
        return sb.toString() + s;
    }

    // 5 ms
    // very smart solution
    public String shortestPalindrome3(String s) {
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())  return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }
}
