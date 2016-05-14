package leetcode;
import java.util.*;

/**
 * Created by Hua on 5/14/2016.
 *
 *  Given an array of words and a length L, format the text such that
 *  each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach;
 that is, pack as many words as you can in each line.
 Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words,
 the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is
 inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length.

 click to show corner cases.
 Corner Cases:

 A line other than the last line might contain only one word.
 What should you do in this case?
 In this case, that line should be left-justified.
 */

public class N68_TextJustification {
    // 6 ms
    // can use index to optimise speed.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int cur_len=0;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(cur_len == 0)cur_len += words[i].length();
            else cur_len += words[i].length() + 1;

            if(cur_len > maxWidth ){
                formALine(ret,list,maxWidth);

                // reset parameters
                i--;
                cur_len=0;
                list.clear();
            }else{
                list.add(words[i]);
            }
        }

        if(list.size()!=0) formALine(ret,list,maxWidth);
        formatLastLine(ret, maxWidth);
        return ret;
    }

    private String gen_space_string(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append(" ");
        return sb.toString();
    }

    private void formALine(List<String> ret, ArrayList<String> list, int maxWidth){
        int word_len = 0;
        for(String e: list) word_len+=e.length();
        int space_len = maxWidth - word_len;
        StringBuilder sb = new StringBuilder();

        if(list.size() == 1) {
            sb.append(list.get(0));
            String spaces = gen_space_string(space_len);
            sb.append(spaces);
            ret.add(sb.toString());
        }
        else{
            int common_space_len = space_len / (list.size()-1);
            int remaining_space_len = space_len % (list.size()-1);
            String spaces = gen_space_string(common_space_len);
            for(String e: list){
                sb.append(e);
                sb.append(spaces);
                if(remaining_space_len>0){
                    sb.append(" ");
                    remaining_space_len--;
                }
            }
            ret.add(sb.substring(0,sb.length() - common_space_len).toString());
        }
    }

    private void formatLastLine(List<String> ret, int maxWidth){
        if(ret.size()==0) return;

        String s = ret.remove(ret.size() - 1);
        int words_len = 0;
        String[] words = s.trim().split(" +");
        for(String e: words) words_len+=e.length();

        int trailing_spaces_len = maxWidth - words_len - words.length +1;
        String trailing_spaces = gen_space_string(trailing_spaces_len);
        //build string
        StringBuilder sb = new StringBuilder();
        for(String e: words){
            sb.append(e);
            sb.append(" ");
        }
        sb.append(trailing_spaces);
        ret.add(sb.substring(0,sb.length()-1).toString());
    }
}
