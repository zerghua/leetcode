package leetcode;

import java.util.*;
import java.util.stream.Collector;

/**
 * Created by Hua on 8/7/16.

 Given a string which contains only lowercase letters,
 remove duplicate letters so that every letter appear once and only once.
 You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:

 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"

 */
public class N316_RemoveDuplicateLetters {
    // 4 ms
    // count each char first, save the condition if this char will come later or not
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray(); // optimize code
        int[] count = new int[128];
        for(char c: chars) count[c]++; // count each char in string

        LinkedList<Character> list = new LinkedList<>();
        boolean[] isVisited = new boolean[128];
        for(int i=0;i<chars.length;i++){
            char curChar = chars[i];
            count[curChar]--;
            if(isVisited[chars[i]]) continue;

            // this is the key
            while(!list.isEmpty() && list.getLast() > curChar && count[list.getLast()]>0){
                isVisited[list.removeLast()] = false;
            }

            list.add(curChar);
            isVisited[curChar] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c :list) sb.append(c);
        return sb.toString();
    }
}
