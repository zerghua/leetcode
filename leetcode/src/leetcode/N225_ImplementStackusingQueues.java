package leetcode;
import java.util.*;

//34 ms  2 queues, o(1) push, o(n) top and pop
public class N225_ImplementStackusingQueues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();	
    // Push element x onto stack.
    public void push(int x) {
        if(q1.isEmpty()) q2.add(x);
        else q1.add(x);
    }
    // Removes the element on top of the stack.
    public void pop() {
        if(q1.isEmpty()) {
        	//move n-1 element from q2 to q1
        	while(q2.size()!=1)q1.add(q2.remove());
        	q2.remove();
        }else{
        	//move n-1 element from q1 to q2
        	while(q1.size()!=1)q2.add(q1.remove());
        	q1.remove();        	
        }
    }
    // Get the top element.
    public int top() {
    	int ret = 0;
        if(q1.isEmpty()) {
        	//move n-1 element from q2 to q1
        	while(q2.size()!=1)q1.add(q2.remove());
        	ret =q2.peek();
        	q1.add(q2.remove());
        }else{
        	//move n-1 element from q1 to q2
        	while(q1.size()!=1)q2.add(q1.remove());
        	ret =q1.peek();
        	q2.add(q1.remove());        	
        }        
    	return ret;
    }
    // Return whether the stack is empty.
    public boolean empty() {
    	return q1.isEmpty() && q2.isEmpty();
    }
    
    
    // 30 ms 1 queue o(1) push, o(n) top and pop
    class myStack1{
    	Queue<Integer> q = new LinkedList<Integer>();
    	public void push(int x) {
    		q.add(x);
    	}
    	public void pop() {
    		int size =q.size();
    		for(int i=1; i<size;i++ )q.add(q.remove());
    		q.remove();
    	}	
    	public int top() {
    		int size =q.size();
    		for(int i=1; i<size;i++ )q.add(q.remove());
    		int ret = q.peek();
    		q.add(q.remove());
    		return ret;
    	}
    	public boolean empty() {
    		return q.isEmpty();
    	}
    }
    
    //30 ms 2 queues, o(n) push, o(1) top and pop
    // stored reversed element on q1, push new element to q2, add all q1 to q2 and copied back
    class myStack2{
    	Queue<Integer> q1 = new LinkedList<Integer>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	public void push(int x) {
    		q2.add(x);
    		while(!q1.isEmpty()){
    			q2.add(q1.remove());
    		}
    		Queue<Integer> tmp = q2;
    		q2=q1;
    		q1=tmp;
    	}
    	public void pop() {
    		q1.remove();
    	}
    	public int top() {
    		return q1.peek();
    	}	
    	public boolean empty() {
    		return q1.isEmpty();
    	}
    }    
    
}
