package test.app.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack queue = new QueueUsingStack();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		System.out.println(queue.pop());
		
		queue.push(4);
		
		System.out.println(queue.pop());
				
	}
	
	Deque<Integer> stack1,stack2;
	Integer front;
 	
	public QueueUsingStack() {
		stack1 = new ArrayDeque<>();
		stack2 = new ArrayDeque<>();
	}
	
	public void push(int x) {
        if( stack1.isEmpty() )
        	front = x;
        
        stack1.push(x);
    }
    
    public int pop() {
    	if( stack2.isEmpty() ) {
    		while( !stack1.isEmpty() )
    			stack2.push(stack1.pop());
    	}
    	
    	return stack2.pop();
    }
    
    public int top() {
    	if( stack2.isEmpty() ) {
    		return front;
    	}
    	
    	return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
