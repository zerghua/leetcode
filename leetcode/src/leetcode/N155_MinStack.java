package leetcode;
import java.util.*;
/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.

 */



public class N155_MinStack {
    // Google, Amazon
    // concise code added on 10/15/2016
    // 113 ms 18 / 18 test cases passed.
    // pop and min when stack is empty is undefined.
    public class MinStack {
        Stack<Integer> s, minStack;
        public MinStack() {
            s = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            s.push(x);
            if(minStack.isEmpty() || x <= minStack.peek() ) minStack.push(x); // >= to handle duplicate
        }

        public void pop() {
            int e = s.pop();
            if(e == minStack.peek()) minStack.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    // 12 ms
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
