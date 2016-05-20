package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Hua on 5/20/2016.
 *
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".


 vowels: a, e, i, o, u
 */
public class N345_ReverseVowelsofaString {
    // 23 ms
    // corner case: up and lower case
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(vowels.contains(Character.toLowerCase(chars[i])))list.add(i);
        }

        for(int index=0;index<list.size()/2;index++)
        {
            int i= list.get(index);
            int j= list.get(list.size()-index-1);
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return String.valueOf(chars);
    }

    //18 ms
    public String reverseVowels2(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char[] chars = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<j)
        {
            if(!vowels.contains(Character.toLowerCase(chars[i]))){
                i++;
                continue;
            }

            if(!vowels.contains(Character.toLowerCase(chars[j]))){
                j--;
                continue;
            }

            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;j--;
        }
        return String.valueOf(chars);
    }

}
