package leetcode;
import java.util.*;
/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection
between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters,
and str contains lowercase letters separated by a single space.

 */
public class N290_WordPattern {
	//7 ms
    public static boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.trim().split("\\s+");
        if(splitStr.length != pattern.length()) return false;
        Character a_char;
        String a_word;
        HashMap<Character, String> hm_char_as_key = new HashMap<Character, String>();
        HashMap<String, Character> hm_word_as_key = new HashMap<String, Character>();
        for(int i=0;i<pattern.length();i++){
        	a_char = pattern.charAt(i);
        	a_word = splitStr[i];
        	System.out.println(a_char + " " + a_word);
        	
        	if(hm_char_as_key.containsKey(a_char)) {
        		if(!hm_char_as_key.get(a_char).equals(a_word)) return false;
        	}else hm_char_as_key.put(a_char, a_word);
        	
        	if(hm_word_as_key.containsKey(a_word)) {
        		if(!hm_word_as_key.get(a_word).equals(a_char)) return false;
        	}else hm_word_as_key.put(a_word, a_char);
        	
        }
        return true;
    }
    
    public static void main(String[] args){
    	String a="abba";
    	String b="dog cat cat dog" ;
    	String[] splitStr = b.trim().split("\\s+");
    	
    	System.out.println(wordPattern(a,b));
    }

    // solution 2,3 added on 9/23/2016
    // 5 ms 29 / 29 test cases passed.
    public class Solution2 {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length()) return false;
            Map index = new HashMap();
            for (int i=0; i<words.length; ++i)
                if (!Objects.equals(index.put(pattern.charAt(i), i),
                        index.put(words[i], i)))
                    return false;
            return true;
        }
    }

    // 4 ms  29 / 29 test cases passed.
    // very similar to N205 isomorphic Strings.
    public class Solution3 {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if(words.length != pattern.length()) return false;
            char[] pattern_array = pattern.toCharArray();
            HashMap<Object,Integer> map = new HashMap();
            for(Integer i=0;i<words.length;i++){
                if(map.put(pattern_array[i],i) != map.put(words[i],i)) return false;
            }
            return true;
        }
    }
    
}
