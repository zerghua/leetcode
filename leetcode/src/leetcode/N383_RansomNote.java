package leetcode;

/**
 * Created by HuaZ on 8/15/2016.

 Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from 
 all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  
 be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true


 */
public class N383_RansomNote {
    // Apple
    // 14 ms
    // hash table
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[128];
        for(char c: magazine.toCharArray()) mag[c]++;
        for(char c: ransomNote.toCharArray()){
            if(--mag[c] < 0) return false;
        }
        return true;
    }
}
