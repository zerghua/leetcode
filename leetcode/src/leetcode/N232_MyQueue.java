package leetcode;
import java.util.*;


//228 ms  6%
public class N232_MyQueue {
	Stack<Integer> in_stack = new Stack<Integer>();
	Stack<Integer> out_stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
    	in_stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(out_stack.isEmpty()){
        	while(!in_stack.isEmpty()) out_stack.push(in_stack.pop());
        }
        out_stack.pop();
    }

    // Get the front element.
    public int peek() {
        if(out_stack.isEmpty()){
        	while(!in_stack.isEmpty()) out_stack.push(in_stack.pop());
        }    	
    	return out_stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in_stack.isEmpty() && out_stack.isEmpty();
    }
}
