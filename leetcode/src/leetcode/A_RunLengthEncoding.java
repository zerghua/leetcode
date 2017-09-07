package leetcode;

/**
 * Created by Hua on 9/7/2017.

 https://en.wikipedia.org/wiki/Run-length_encoding

 Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data
 (that is, sequences in which the same data value occurs in many consecutive data elements) are stored
 as a single data value and count, rather than as the original run.

 This is most useful on data that contains many such runs. Consider, for example,
 simple graphic images such as icons, line drawings, and animations.
 It is not useful with files that don't have many runs as it could greatly increase the file size.

 Typical applications of this encoding are when the source information
 comprises long substrings of the same character or binary digit.



 WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW

 With a run-length encoding (RLE) data compression algorithm applied to the above hypothetical scan line,
 it can be rendered as follows:

 12W1B12W3B24W1B14W



 Follow up question: what if count overflow?
 Use string to represent int.(Then it becomes large number string add problem)


 */

import java.util.*;
public class A_RunLengthEncoding {
    public String RLE(String s){
        if(s == null || s.length() == 0) return s;
        int i=0, j=0, n = s.length();
        StringBuilder ret = new StringBuilder();
        while(j < n){
            if(s.charAt(i) == s.charAt(j))j++;
            else{
                ret.append((j-i) + "" + s.charAt(i));
                i = j;
            }
        }
        if(j > i)ret.append((j-i) + "" + s.charAt(i));
        return ret.toString();
    }


    public String decode(String s){
        int num = 0;
        StringBuilder ret = new StringBuilder();
        for(int i=0 ; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                num = num *10 + s.charAt(i) - '0';
                if(num == 0) throw new IllegalArgumentException("invalid input");
            }
            else{
                for(int k =0; k<num; k++) ret.append(s.charAt(i));
                num = 0;
            }
        }
        return ret.toString();
    }


    public void print(List<String> list){
        for(String s : list) {
            String code = RLE(s);
            String decode = decode(code);
            System.out.println(s + ", RLE: [" + code +"] after decode: " + decode  + " " + (decode.equals(s)));
        }
    }



    public static void main(String[] args){
        A_RunLengthEncoding a = new A_RunLengthEncoding();
        a.print(Arrays.asList("aaabb", "aaaaa", "aaaab", "abbbbc", "aaaaaaaaaabbc"));
    }


}
