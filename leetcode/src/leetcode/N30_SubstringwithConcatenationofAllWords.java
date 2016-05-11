package leetcode;
import java.util.*;

/**
 * Created by Hua on 5/10/2016.
 *
 *  You are given a string, s, and a list of words, words, that are all of the same length.
 *  Find all starting indices of substring(s) in s that is a concatenation of each word
 *  in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class N30_SubstringwithConcatenationofAllWords {
    // 184 ms
    // two hash map, to compare count
    // time o(nm), may be improved
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();

        // put count of each words in hash map
        HashMap<String, Integer> map = new HashMap<>();
        for(String e: words) {
            if(map.containsKey(e)) map.put(e, map.get(e)+1);
            else map.put(e,1);
        }

        int word_len = words[0].length();
        int num_of_word = words.length;
        int total_word_len = word_len * num_of_word;
        for(int i=0; i<= s.length()-total_word_len; i++){
            if(isValid(s, map, i, word_len, num_of_word)) ret.add(i);
        }
        return ret;
    }

    private boolean isValid(String s, HashMap<String, Integer> map,
                            int start, int word_len, int num_of_word) {
        HashMap<String, Integer> current_map = new HashMap<>();
        for(int i=0;i<num_of_word;i++){
            String word = s.substring(start+i*word_len, start+i*word_len+word_len);
            if(!map.containsKey(word)) return false;

            if(current_map.containsKey(word)) current_map.put(word, current_map.get(word)+1);
            else current_map.put(word,1);

            if(current_map.get(word) > map.get(word)) return false;
        }
        return true;
    }

}
