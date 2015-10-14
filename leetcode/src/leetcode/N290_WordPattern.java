package leetcode;
import java.util.*;

/*
public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (int i=0; i<words.length; ++i)
        if (!Objects.equals(index.put(pattern.charAt(i), i),
                            index.put(words[i], i)))
            return false;
    return true;
}
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
    
}
