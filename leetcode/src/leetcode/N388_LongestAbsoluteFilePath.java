package leetcode;

/**
 * Created by Hua on 10/25/2016.

 Google online assessment.

 Suppose we abstract our file system by a string in the following manner:

 The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

 dir
     subdir1
     subdir2
        file.ext

 The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

 dir
     subdir1
        file1.ext
        subsubdir1
     subdir2
         subsubdir2
            file2.ext

 The directory dir contains two sub-directories subdir1 and subdir2.
 subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

 We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
 and its length is 32 (not including the double quotes).

 Given a string representing the file system in the above format, return the length of the longest absolute path
 to file in the abstracted file system. If there is no file in the system, return 0.

 Note:

 The name of a file contains at least a . and an extension.
 The name of a directory or sub-directory will not contain a ..

 Time complexity required: O(n) where n is the size of the input string.

 Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

 */
import java.util.*;
public class N388_LongestAbsoluteFilePath {
    // Google
    // 25 / 25 test cases passed.  on 8/22/2017
    // 4 ms
    public class Solution {
        public int lengthLongestPath(String input) {
            String[] paths = input.split("\n");
            int[] stack = new int[paths.length+1];
            int maxLen = 0;
            for(String s:paths){
                int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
                if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
            }
            return maxLen;
        }
    }


    // map<level, count_of_char>
    // 4 ms 25 / 25 test cases passed.
    public class Solution2 {
        public int lengthLongestPath(String input) {
            int ret = 0;
            HashMap<Integer, Integer> map = new HashMap();
            map.put(0,0);
            for(String line: input.split("\n")){
                int level = line.lastIndexOf("\t") + 1;
                int curLen = line.substring(level).length(); // "\t"(tab) is counted a one char
                if(line.contains(".")){
                    ret = Math.max(ret, map.get(level) + curLen);
                }else{
                    map.put(level+1, map.get(level) + curLen + 1);  //level+1 to avoid a corner case when last level is 0.
                }
            }
            return ret;
        }
    }
}
