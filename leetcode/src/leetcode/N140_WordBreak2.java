package leetcode;
import java.util.*;

/**
 * Created by Hua on 7/5/16.

 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence
 where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 */
public class N140_WordBreak2 {
    // Google, Uber
    // http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
    // 21 ms
    // DP + backtracking. use Arraylist array to store previous words.
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String>[] preWordsList = new ArrayList[s.length()+1];
        preWordsList[0] = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(preWordsList[i] != null){
                for(int j=i+1;j<=s.length();j++) {
                    String word = s.substring(i, j);
                    if(wordDict.contains(word)) {
                        if(preWordsList[j] == null) preWordsList[j] = new ArrayList<>(Arrays.asList(word));
                        else preWordsList[j].add(word);
                    }
                }
            }
        }

        //backtracking result
        List<String> ret = new LinkedList<>();
        if(preWordsList[s.length()] != null){
            backTrackResult(ret, preWordsList, "", s.length());
        }
        return ret;
    }

    public void backTrackResult(List<String> ret, ArrayList<String>[] preWordList, String curStr, int index){
        if(index == 0){
            ret.add(curStr.trim());
            return;
        }
        for(String word: preWordList[index]){
            backTrackResult(ret, preWordList, word + " " + curStr, index - word.length());
        }
    }

}
