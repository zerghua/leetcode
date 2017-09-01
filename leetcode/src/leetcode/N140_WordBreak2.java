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
    // find all possible answers are usually backtracking
    // backtracking + memo(to speed up)
    // 37 / 37 test cases passed.  on 8/27/2017
    // 11 ms
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            return dfs(s, wordDict, new HashMap());
        }

        public List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map){
            if(map.containsKey(s)) return map.get(s);

            List<String> ret = new ArrayList();
            if(s.length() == 0){
                ret.add("");  // make sure returned list have at least one item, or loop 0-size list will error out
                return ret;
            }

            for(String word : wordDict){
                if(s.startsWith(word)){
                    List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                    for(String str : subList)
                        ret.add(word + (str.length()==0 ? "" : " ") + str);  // str.length()==0  == str.isEmpty()
                }
            }
            map.put(s, ret);
            return ret;
        }
    }

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
