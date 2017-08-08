package leetcode;

/**
 * Created by Hua on 8/24/16.

 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 Note: You may assume the string contain only lowercase letters.


 */
public class N387_FirstUniqueCharacterinaString {
    // Amazon, Microsoft
    // 16 ms  o(n) time.
    public int firstUniqChar(String s) {
        int[] map = new int[128]; // contains all lowercase chars
        char[] chars = s.toCharArray();
        for(char c: chars) map[c]++;

        for(int i=0;i<chars.length;i++) {
            if(map[chars[i]] == 1) return i;
        }
        return -1;
    }




}
