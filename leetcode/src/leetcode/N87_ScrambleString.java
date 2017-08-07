package leetcode;

/**
 * Created by Hua on 4/24/2016.

 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

        great
       /    \
     gr    eat
    / \    /  \
   g   r  e   at
  / \
 a   t

 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

       rgeat
      /    \
     rg    eat
    / \    /  \
   r   g  e   at
  / \
 a   t

 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

       rgtae
      /    \
     rg    tae
    / \    /  \
   r   g  ta  e
  / \
 t   a

 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

 */
public class N87_ScrambleString {
    // no company
    // recursive
    // 4 ms
    // recursively compare sub string.
    public boolean isScramble(String s1, String s2) {
        if( !isPermutation(s1, s2) ) return false;  //corner case, can also use sort to compare.
        if(s1.equals(s2)) return true;

        for(int i=1; i<s1.length(); i++){
            String s1_1 = s1.substring(0,i);
            String s1_2 = s1.substring(i,s1.length());
            String s2_1 = s2.substring(0,i);
            String s2_2 = s2.substring(i,s2.length());
            if(isScramble(s1_1, s2_1) && isScramble(s1_2, s2_2)) return true;

            s2_1 = s2.substring(s2.length()-i,s2.length());
            s2_2 = s2.substring(0,s2.length()-i);
            if(isScramble(s1_1, s2_1) && isScramble(s1_2, s2_2)) return true;
        }
        return false;
    }

    // assume all chars are lower-case english chars
    public boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] a = new char[26];
        for(int i=0; i<s1.length();i++){
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++)  if(a[i] != 0) return false;
        return true;
    }

    //can also use DP
}
