package leetcode;

/**
 * Created by Hua on 7/27/2017.

 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example,
 it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.

 */
public class N158_ReadNCharactersGivenRead4IICallmultipletimes {

    public class Reader4{
        /* The read4 API is defined in the parent class Reader4.
            int read4(char[] buf); */
        public int read4(char[] buf){
            return 0;
        }
    }

    // google, facebook, bloomberg
    // 81 / 81 test cases passed.
    // 2 ms
    public class Solution extends Reader4 {

        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */

        int i4 = 0, n4 = 0; // keep track of last operation
        char[] buf4 = new char[4];
        public int read(char[] buf, int n) {
            int i=0;        // i may be less than n, so can't read n chars.
            while(i < n){
                if(i4 >= n4){
                    i4 = 0;
                    n4 = read4(buf4);
                    if(n4 == 0) break; // end of file.
                }
                buf[i++] = buf4[i4++];
            }
            return i;
        }
    }

}
