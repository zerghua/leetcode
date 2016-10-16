package leetcode;

/**
 * Created by HuaZ on 10/16/2016.

 Given an integer, write an algorithm to convert it to hexadecimal.
 For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s.
 If the number is zero, it is represented by a single zero character '0';
 otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.

 Example 1:

 Input:
 26

 Output:
 "1a"

 Example 2:

 Input:
 -1

 Output:
 "ffffffff"

 */
public class N405_ConvertaNumbertoHexadecimal {
    // 7 ms 100 / 100 test cases passed.
    // interesting way decimal to hexdecimal.
    public String toHex(int num) {
        if(0<=num && num<10) return ""+num;
        StringBuilder ret = new StringBuilder();
        char[] hex = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        for(int i=0;i<8;i++){
            ret.insert(0, hex[num & 15]);
            num >>= 4;
        }
        // remove leading zeros
        int start=0;
        while(ret.charAt(start) == '0') start++;
        return ret.substring(start).toString();
    }
}
