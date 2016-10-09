package leetcode;
import java.util.*;

/*
public static boolean isValid(String s) {
	HashMap<Character, Character> map = new HashMap<Character, Character>();
	map.put('(', ')');
	map.put('[', ']');
	map.put('{', '}');
 
	Stack<Character> stack = new Stack<Character>();
 
	for (int i = 0; i < s.length(); i++) {
		char curr = s.charAt(i);
 
		if (map.keySet().contains(curr)) {
			stack.push(curr);
		} else if (map.values().contains(curr)) {
			if (!stack.empty() && map.get(stack.peek()) == curr) {
				stack.pop();
			} else {
				return false;
			}
		}
	}
 
	return stack.empty();
}

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


version 2,3 added on 8/31/2016

 */

public class N20_ValidParentheses {
	//3 ms
	public boolean isMatch(char left, char right){
		if(left== '(' && right== ')' ) return true;
		if(left== '[' && right== ']' ) return true;
		if(left== '{' && right== '}' ) return true;
		return false;
	}
	
    public boolean isValid(String s) {
    	if(s==null || s.length()==0) return true;
    	
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	if(stack.isEmpty()) stack.push(s.charAt(i));
        	else {
        		char c = stack.peek();
        		if(isMatch(c, s.charAt(i))) stack.pop();
        		else stack.push(s.charAt(i));
        	}
        }
        
        if(stack.isEmpty())return true;
        else return false;
    }


    // 3 ms
    public boolean isValid2(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(' || c=='{' || c=='[') stack.push(c);
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }

    // 1 ms
    public boolean isValid3(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(' || c=='{' || c=='[') stack.push(c);
            else if (!stack.isEmpty()){
                if (c == ')' && stack.peek() == '(') stack.pop();
                else if (c == ']'  && stack.peek() == '[') stack.pop();
                else if (c == '}'  && stack.peek() == '{') stack.pop();
                else return false;
            }
            else return false;
        }
        return stack.isEmpty();
    }

    // concise code added on 10/9/2016
    // 7 ms 65 / 65 test cases passed.
    public class Solution {
        public boolean isValid(String s) {
            if(s==null || s.length()==0) return true;
            HashMap<Character, Character> map = new HashMap(){{
                put('(',')');
                put('{','}');
                put('[',']');
            }};
            Stack<Character> stack = new Stack();
            for(char c : s.toCharArray()){
                if(map.containsKey(c)) stack.push(c);
                else if(stack.isEmpty() || map.get(stack.pop()) != c) return false; // concise code.
            }
            return stack.isEmpty();
        }
    }










}
