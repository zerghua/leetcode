package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/7/2016.
 */

public class N139_WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreak(0,s,wordDict);
    }

    // TLE
    public boolean wordBreak(int start, String s, Set<String> wordDict){
        if(start >= s.length()) return true;

        boolean isFound= false;
        for(int i=start; i<s.length(); i++){
            String tmp = s.substring(start,i+1);
            if(wordDict.contains(tmp)) isFound= wordBreak(i+1, s, wordDict);
            if(isFound) return true;
        }

        return false;
    }

    //6 ms
    public boolean wordBreak_dp(String s, Set<String> wordDict) {
        boolean[] isbreakable = new boolean[s.length()+1];
        isbreakable[0] = true;
        for(int i=0;i<s.length();i++){
            for(int j=i; j>=0; j--){
                String tmp = s.substring(j,i+1);
                if(isbreakable[j] && wordDict.contains(tmp)){
                    isbreakable[i+1] = true;
                    break;
                }
            }
        }
        return isbreakable[s.length()];
    }

}