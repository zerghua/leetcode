package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/18/2016.
 */

public class N151_ReverseWordsinaString {
    //12 ms
    public String reverseWords(String s) {
        String[] a = s.trim().split(" +");
        for(int i=0; i<a.length/2; i++){
            String tmp = a[i];
            a[i] = a[a.length - i -1];
            a[a.length - i -1] = tmp;
        }

        StringBuilder ret = new StringBuilder();
        for(String e: a) ret.append(e + " ");

        return ret.toString().trim();
    }

    // no need to reverse, just push to builder backwards
    // 11 ms
    public String reverseWords2(String s) {
        String[] a = s.trim().split(" +"); // will handle multiple space cases.
        StringBuilder ret = new StringBuilder();
        for(int i=a.length-1; i>=0; i--) ret.append(a[i]+" ");
        return ret.toString().trim();
    }
}
