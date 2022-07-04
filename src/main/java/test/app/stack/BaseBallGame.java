package test.app.stack;

import java.util.Queue;
import java.util.Stack;

public class BaseBallGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println( new BaseBallGame().calPoints(ops));
	}
	
	public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i < ops.length ; i++) {
            if( "C".equals(ops[i]) ) {
            	stack.pop();
            } else if( "D".equals(ops[i])  ) {
            	stack.push(2*stack.peek());
            } else if( "+".equals(ops[i])  ) {
            	int e1 = stack.pop();
            	int e2 = stack.pop();
            	stack.push(e2);
            	stack.push(e1);
            	stack.push(e1+e2);
            } else {
            	stack.push(Integer.parseInt(ops[i]));
            }
        }
        
        int sum = 0;
        
        for(int e : stack ) {
        	sum += e;
        }
        
        return sum;
    }

}
