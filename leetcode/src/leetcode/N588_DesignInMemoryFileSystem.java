package leetcode;

/**
 * Created by HuaZ on 7/30/2017.

 Design an in-memory file system to simulate the following functions:

 ls: Given a path in string format. If it is a file path,
 return a list that only contains this file's name. If it is a directory path,
 return the list of file and directory names in this directory.
 Your output (file and directory names together) should in lexicographic order.

 mkdir: Given a directory path that does not exist,
 you should make a new directory according to the path.
 If the middle directories in the path don't exist either,
 you should create them as well. This function has void return type.

 addContentToFile: Given a file path and file content in string format.
 If the file doesn't exist, you need to create that file containing given content.
 If the file already exists, you need to append given content to original content.
 This function has void return type.

 readContentFromFile: Given a file path, return its content in string format.

 Example:

 Input:
 ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 Output:
 [null,[],null,null,["a"],"hello"]
 Explanation:
 filesystem

 Note:

 You can assume all file or directory paths are absolute paths which begin with / and do not end
 with / except that the path is just "/".
 You can assume that all operations will be passed valid parameters and users will not attempt
 to retrieve file content or list a directory or file that does not exist.
 You can assume that all directory names and file names only contain lower-case letters,
 and same names won't exist in the same directory.

 */

import java.util.*;
public class N588_DesignInMemoryFileSystem {
    // Baidu (Premium)
    // design, similar to trie/tree structure
    // 63 / 63 test cases passed.
    // 182 ms
    public class FileSystem {
        class Node{
            String name, content;
            boolean isFile;
            HashMap<String, Node> children;
            Node(String name){
                this.name = name;
                isFile = false;
                children = new HashMap();
                content = "";
            }
        }

        Node root;
        public FileSystem() {
            root = new Node("/");
        }

        private Node getLastFile(String s){
            String[] a = s.split("/");
            Node cur = root;
            for(int i=1; i < a.length; i++){ // 0 will be "" after split s
                if(!cur.children.containsKey(a[i])) cur.children.put(a[i], new Node(a[i]));
                cur = cur.children.get(a[i]);
            }
            return cur;
        }

        public List<String> ls(String path) {
            List<String> ret = new LinkedList();

            Node node = getLastFile(path);
            if(node.isFile) ret.add(node.name);
            else ret.addAll(node.children.keySet());

            Collections.sort(ret); // for lexicographic order
            return ret;
        }

        public void mkdir(String path) {
            getLastFile(path);
        }

        public void addContentToFile(String filePath, String content) {
            Node node = getLastFile(filePath);
            node.isFile = true;
            node.content += content;
        }

        public String readContentFromFile(String filePath) {
            Node node = getLastFile(filePath);
            return node.content;
        }
    }

}
