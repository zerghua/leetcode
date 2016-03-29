package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 3/29/2016.
 */
public class N17_LetterCombinationsofaPhoneNumber {
    //3 ms
    public void letterCombinations(String digits, int digit_start,
                                   HashMap<Character, String> map, String cur, List<String> ret){

        if(cur.length() == digits.length()) {
            ret.add(cur);
            return;
        }

        String chars = map.get(digits.charAt(digit_start));
        for(int j=0; j<chars.length(); j++){
            letterCombinations(digits, digit_start+1,map, cur + chars.charAt(j), ret);
        }
    }


    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        List<String> ret = new LinkedList<>();
        if(digits.equals("")) return ret;

        letterCombinations(digits, 0, hm, "", ret);
        return ret;
    }



    //using string array  1ms.
    public void letterCombinations2(String digits, int digit_start,
                                   String[] map, String cur, List<String> ret){

        if(cur.length() == digits.length()) {
            ret.add(cur);
            return;
        }

        String chars = map[digits.charAt(digit_start) - '0'];
        for(int j=0; j<chars.length(); j++){
            letterCombinations2(digits, digit_start + 1, map, cur + chars.charAt(j), ret);
        }
    }

    public List<String> letterCombinations2(String digits) {
        String[] hm = {"", "", "abc",
                "def", "ghi", "jkl",
                "mno", "pqrs", "tuv","wxyz"};


        List<String> ret = new LinkedList<>();
        if(digits == null || digits.length()==0) return ret;

        letterCombinations2(digits, 0, hm, "", ret);
        return ret;
    }


}
