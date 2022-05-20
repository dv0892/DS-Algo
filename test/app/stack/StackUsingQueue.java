package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		
	}
	
	Deque<Integer> queue;
 	
	public StackUsingQueue() {
		queue = new ArrayDeque<>();
	}
	
	public void push(int x) {
        queue.add(x);
        
        int ops = queue.size()-1;
        while(ops-- > 0) {
        	queue.add(queue.remove());
        }
    }
    
    public int pop() {
    	if(!queue.isEmpty())
    		return queue.poll();
    	return -1;
    }
    
    public int top() {
    	if(!queue.isEmpty())
    		return queue.peek();
    	return -1;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

}
