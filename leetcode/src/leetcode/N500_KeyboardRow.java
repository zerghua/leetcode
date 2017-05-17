package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/15/2017.

 Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
 American keyboard like the image below.

 American keyboard

 Example 1:

 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]

 Note:

 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.

 */
public class N500_KeyboardRow {
    // hash map.
    // 22 / 22 test cases passed.
    // 4 ms
    public class Solution {
        public String[] findWords(String[] words) {
            String[] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            HashMap<Character, Integer> map = new HashMap();
            for(int i=0; i<strs.length; i++){
                for(char c : strs[i].toCharArray()) map.put(c, i);
            }

            ArrayList<String> list= new ArrayList();
            for(String s: words){
                if(s.equals("")) continue;
                int index = map.get(s.toLowerCase().charAt(0));
                for(char c : s.toLowerCase().toCharArray()){
                    if(index != map.get(c)){
                        index = -1;
                        break;
                    }
                }
                if(index != -1) list.add(s);
            }
            return list.toArray(new String[0]);
        }
    }

}
