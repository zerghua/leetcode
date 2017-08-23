package leetcode;

/**
 * Created by HuaZ on 10/18/2016.

 A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

 For 1-byte character, the first bit is a 0, followed by its unicode code.
 For n-bytes character, the first n-bits are all one's, the n+1 bit is 0,
 followed by n-1 bytes with most significant 2 bits being 10.

 This is how the UTF-8 encoding would work:

 Char. number range  |        UTF-8 octet sequence
    (hexadecimal)    |              (binary)
 --------------------+---------------------------------------------
 0000 0000-0000 007F | 0xxxxxxx
 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

 Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

 Note:
 The input is an array of integers.
 Only the least significant 8 bits of each integer is used to store the data.
 This means each integer represents only 1 byte of data.

 Example 1:

 data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

 Return true.
 It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.

 Example 2:

 data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

 Return false.
 The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 The next byte is a continuation byte which starts with 10 and that's correct.
 But the second continuation byte does not start with 10, so it is invalid.



 Rule 2:
 Record the count of consecutive of 1.
 Move the number 5 bit right, if it equals "110" means there is one '1'.
 Move the number 4 bit right, if it equals "1110" means there are two '1'.
 ...
 Move the number 7 bit right, if it equals "1" means it is "10000000" which has no meaning, return false.

 Rule 1:
 If it is not started with "10", return false;


 */
public class N393_UTF8Validation {
    // Google
    // find pattern. need a counter to record when to return false.
    // the only thing to verify is:
    // if 4 bytes, start with 0b11110, it should follow 3 of start with 0b10
    // if 3 bytes, start with 0b1110, it should follow 2 of start with 0b10
    // if 2 bytes, start with 0b110, it should follow 1 of start with 0b10
    // if none above and first is 1, it's also invalid
    // 8 ms 45 / 45 test cases passed.
    public class Solution {
        public boolean validUtf8(int[] data) {
            int count =0;
            for(int n : data){
                if(count == 0){
                    if( (n>>5) == 0b110) count = 1;
                    else if ((n>>4) == 0b1110) count = 2;
                    else if ((n>>3) == 0b11110) count = 3;
                    else if ( (n>>7) == 1) return false; //fail if not one byte.
                    //else,  OK if it's one byte
                }else{
                    if( (n>>6) != 0b10) return false;
                    count--;
                }
            }
            return count==0;
        }
    }
}
