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
    // 8 ms
    // StringTokenizer, or can use split as well.  String[] arr = path.split("/");
    // StringBuilder is unsynchronized(faster) and StringBuffer is synchronized(thread safe)
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
