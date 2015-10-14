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
}
