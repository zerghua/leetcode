package leetcode;

/**
 * Created by Hua on 5/17/2016.
 *
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class N344_ReverseString {
    //5 ms
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)sb.append(s.charAt(i));
        return sb.toString();
    }
}
