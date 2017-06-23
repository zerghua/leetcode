package leetcode;

/**
 * Created by Hua on 6/22/2017.

 Given a list of directory info including directory path, and all the files with contents in this directory,
 you need to find out all the groups of duplicate files in the file system in terms of their paths.

 A group of duplicate files consists of at least two files that have exactly the same content.

 A single directory info string in the input list has the following format:

 "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

 It means there are n files (f1.txt, f2.txt ... fn.txt with content
 f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm.
 Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

 The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files
 that have the same content. A file path is a string that has the following format:

 "directory_path/file_name.txt"

 Example 1:

 Input:
 ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 Output:
 [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

 Note:

 No order is required for the final output.
 You may assume the directory name, file name and file content only has letters and digits, and the length of
 file content is in the range of [1,50].
 The number of files given is in the range of [1,20000].
 You may assume no files or directories share the same name in the same directory.
 You may assume each given directory info represents a unique directory. Directory path and file info are
 separated by a single blank space.

 Follow-up beyond contest:

 Imagine you are given a real file system, how will you search files? DFS or BFS?
 If the file content is very large (GB level), how will you modify your solution?
 If you can only read the file by 1kb each time, how will you modify your solution?
 What is the time complexity of your modified solution? What is the most time-consuming part
 and memory consuming part of it? How to optimize?
 How to make sure the duplicated files you find are not false positive?


 1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
 In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in
 inside directories, and therefore will probably be faster

 2. If the file content is very large (GB level), how will you modify your solution?
 In a real life solution we will not hash the entire file content, since it's not practical.
 Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different.
 We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same,
 we will compare the files byte by byte


 3. If you can only read the file by 1kb each time, how will you modify your solution?
 This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if
 a full byte by byte comparison is required.

 What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
 Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

 How to make sure the duplicated files you find are not false positive?
 We will use several filters to compare: File size, Hash and byte by byte comparisons.


 */
import java.util.*;
public class N609_FindDuplicateFileinSystem {
    // hashmap and string parsing
    // 161 / 161 test cases passed.
    // 75 ms
    public class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            HashMap<String, List<String>> map = new HashMap();
            //parse input
            for(String s : paths){
                String[] a = s.split(" ");
                String root_dir = a[0];

                // parsing file and its content
                for(int i=1 ;i<a.length; i++){
                    String[] file = a[i].split("\\(");
                    String content = file[1].substring(0, file[1].length()-1);

                    // store content and path in hashmap<String, List>
                    if(!map.containsKey(content)) map.put(content, new ArrayList());
                    map.get(content).add(root_dir + "/" + file[0]);
                }
            }

            // return list.size > 1 in hashmap
            List<List<String>> ret = new ArrayList();
            for(String key: map.keySet()){
                if(map.get(key).size() > 1){
                    ret.add(new ArrayList(map.get(key)));
                }
            }
            return ret;
        }
    }
}
