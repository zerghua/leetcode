package leetcode;

/**
 * Created by HuaZ on 7/23/2017.

 An abbreviation of a word follows the form <first letter><number><last letter>.
 Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n

 Assume you have a dictionary and given a word, find whether its abbreviation is unique
 in the dictionary. A word's abbreviation is unique if no other word from the dictionary
 has the same abbreviation.

 Example:

 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") ->
 false

 isUnique("cart") ->
 true

 isUnique("cane") ->
 false

 isUnique("make") ->
 true


 The description (A word's abbreviation is unique if no other word from the dictionary
 has the same abbreviation) is clear however a bit twisting. It took me a few "Wrong Answer"s
 to finally understand what it's asking for.
 We are trying to search for a word in a dictionary. If this word (also this word’s abbreviation)
 is not in the dictionary OR this word and only it’s abbreviation in the dictionary.
 We call a word’s abbreviation unique.
 EX:

 1) [“dog”]; isUnique(“dig”);

 //False, because “dig” has the same abbreviation with “dog" and “dog” is already in the dictionary.
 It’s not unique.

 2) [“dog”, “dog"]; isUnique(“dog”);

 //True, because “dog” is the only word that has “d1g” abbreviation.

 3) [“dog”, “dig”]; isUnique(“dog”);

 //False, because if we have more than one word match to the same abbreviation,
 this abbreviation will never be unique.



 */

import java.util.*;
public class N288_UniqueWordAbbreviation {
    // google, tricky problem definition
    // BF
    // 54 / 54 test cases passed.
    // 373 ms
    public class ValidWordAbbr {
        String[] dic ;
        public ValidWordAbbr(String[] dictionary) {
            dic = dictionary;
        }

        public boolean isUnique(String word) {
            for(String s : dic){
                if(s.equals(word)) continue; // ok if it's the same
                if(s.length() == word.length() && s.charAt(0) == word.charAt(0) &&
                        s.charAt(s.length()-1) == word.charAt(word.length()-1)) return false;
            }
            return true;
        }
    }

    // hashtable
    // 54 / 54 test cases passed.
    // 228 ms
    public class ValidWordAbbr2 {
        HashMap<String, HashSet<String>> map;
        public ValidWordAbbr2(String[] dictionary) {
            map = new HashMap();
            for(String s : dictionary){
                String key = toAbbr(s);
                if(!map.containsKey(key)) map.put(key, new HashSet());
                map.get(key).add(s);
            }
        }

        public boolean isUnique(String word) {
            String key = toAbbr(word);
            return !map.containsKey(key) || (map.get(key).contains(word) && map.get(key).size() == 1);
        }

        public String toAbbr(String s){
            if(s.length() <= 2) return s;
            return s.charAt(0) + Integer.toString(s.length() -2) + s.charAt(s.length()-1);
        }
    }
}
