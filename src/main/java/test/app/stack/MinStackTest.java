package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MinStack obj = new MinStack();
		
		MinStackSpaceOptimized obj = new MinStackSpaceOptimized();
		
		 obj.push(512);
		 obj.push(-1024);
		 obj.push(-1024);
		 obj.push(512);
		
		 obj.pop();
		 System.out.println(obj.getMin());
		 
		 obj.pop();
		 System.out.println(obj.getMin());
		 
		 obj.pop();
		 System.out.println(obj.getMin());
		 
		 
	}

}


class MinStack {

    Deque<Integer> stack = new ArrayDeque<Integer>();
    Deque<Integer> minStack = new ArrayDeque<Integer>();
    
    public MinStack() {
        stack    = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
        
        stack.push(val);
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek()))
            minStack.pop();
        
        stack.pop();
    }
    
    public int top() {
       return  stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}


class MinStackSpaceOptimized {

    Deque<Long> stack = new ArrayDeque<Long>();
    long min = Integer.MAX_VALUE;
    
    public MinStackSpaceOptimized() {
        stack    = new ArrayDeque<Long>();
    }
    
    public void push(int val) {
        if( stack.isEmpty() ) {
        	stack.push((long)val);
        	min = val;
        	return ;
        }
        
        if( val < min ) {
        	stack.push((long)2*val - min);
        	min = val;
        	return ;
        }
        
        stack.push((long)val);
    }
    
    public void pop() {
    	if( stack.isEmpty() ) {
        	return ;
        }
    	
    	long top = stack.pop();
    	if(top < min) {
    		min = 2*min - top;
    	}

    }
    
    public int top() {
    	if( stack.isEmpty() ) {
        	return -1;
        }
    	
    	long top = stack.peek();
    	if(top < min) {
    		top = min;
    	}
    	
    	return (int) top;
    }
    
    public int getMin() {
        return (int) min;
    }
}