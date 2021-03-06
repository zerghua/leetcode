package leetcode;
import java.util.*;
/**
 * Created by HuaZ on 7/18/2016.
 *
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 click to show corner cases.
 Corner Cases:

 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".



 */
public class N71_SimplifyPath {
    // Facebook, Microsoft
    // stack with some logic
    // 252 / 252 test cases passed.  on 8/17/2017
    // 13 ms
    public class Solution {
        public String simplifyPath(String path) {
            LinkedList<String> list = new LinkedList();
            HashSet<String> set = new HashSet(Arrays.asList(".", ""));
            for(String str : path.split("/")){
                if(str.equals("..")){
                    if(!list.isEmpty())list.removeLast();
                }
                else if(!set.contains(str)) list.add(str);
            }
            StringBuilder  sb = new StringBuilder();
            for(String s: list) sb.append("/").append(s);
            return sb.length() == 0? "/" : sb.toString();
        }
    }


    // 252 / 252 test cases passed.  on 8/17/2017
    // 8 ms
    // StringTokenizer, or can use split as well.  String[] arr = path.split("/");
    // StringBuilder is unsynchronized(faster) and StringBuffer is synchronized(thread safe)
    public class Solution2 {
        public String simplifyPath(String path) {
            StringTokenizer token =  new StringTokenizer(path, "/");
            StringBuilder  sb = new StringBuilder();
            Stack<String> stack = new Stack<>();
            while(token.hasMoreTokens()){
                String str = token.nextToken();
                if(str.equals(".")) continue;
                if(str.equals("..")){
                    if(!stack.isEmpty()) stack.pop();
                }
                else stack.push(str);
            }

            for(String s: stack) sb.append("/").append(s);

            return sb.length() == 0? "/" : sb.toString();
        }
    }
}
