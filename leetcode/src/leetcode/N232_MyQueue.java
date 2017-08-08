package leetcode;
import java.util.*;
/*

 Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Notes:

    You must use only standard operations of a stack --
    which means only push to top, peek/pop from top, size, and is empty operations are valid.

    Depending on your language, stack may not be supported natively.
    You may simulate a stack by using a list or deque (double-ended queue),
    as long as you use only standard operations of a stack.

    You may assume that all operations are valid (for example,
    no pop or peek operations will be called on an empty queue).


 */


public class N232_MyQueue {
    // Microsoft, Bloomberg
    //228 ms  6%
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
