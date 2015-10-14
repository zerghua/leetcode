package leetcode;
import java.util.*;

//12 ms
public class N155_MinStack {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> min_stack = new Stack<Integer>();
	
    public void push(int x) {
    	s.push(x);
    	if(min_stack.isEmpty()) min_stack.push(x);
    	else if(x<=min_stack.peek())min_stack.push(x);
    }

    public void pop() {
        if(!s.isEmpty()) {
        	int i = s.pop();
        	if( i == min_stack.peek())min_stack.pop();
        }
    }

    public int top() {
    	if(!s.isEmpty()) return s.peek();
    	return -1;
    }

    public int getMin() {
        if(!min_stack.isEmpty()) return min_stack.peek();
        return -1;
    }
}
