package leetcode;

/**
 * Created by HuaZ on 10/19/2016.

 The API: int read4(char *buf) reads 4 characters at a time from a file.
 The return value is the actual number of characters read.
 For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n)
 that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.

 */

public class N157_ReadNCharactersGivenRead4 {
    public class Solution{
        /*
         * @param buf Destination buffer
         * @param Maximum number of characters to read
         * @return The number of characters read
         */
        public int read4(char[] buf){
            return 0;
        }

        public int read(char[] buf, int n) {
            boolean isEnd = false;
            char[] bufferWith4 = new char[4];
            int readBytes=0;
            while(!isEnd && readBytes < n){
                int size = read4(bufferWith4);
                if(size < 4) isEnd = true;
                int len = Math.min(n-readBytes, size); //important
                System.arraycopy(bufferWith4,0, buf,readBytes,len); //copy bufferwith4 to buf with length bytes
                readBytes += len;
            }
            return readBytes;
        }
    }
}
