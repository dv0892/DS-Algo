package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeGood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MakeGood().makeGood("ssss"));
	}
	
	 public String makeGood(String s) {
	        
	        if(s.length()==1)
	            return s;
	        
	        Deque<Character> stack = new ArrayDeque<>();
	        
	        int i=0;
	        for( ;i<=s.length()-2;i++){
	            char  ch = s.charAt(i);
	            if(   (ch+32) == s.charAt(i+1) 
	               || (ch-32) == s.charAt(i+1) ) {
	                i++;
	            } else{
	                
	                if(!stack.isEmpty()){
	                    if(   (ch+32) == stack.peek()
	                       || (ch-32) == stack.peek() ) {
	                        stack.pop();
	                        continue;
	                    } 
	                } 
	                
	                stack.push(ch);
	            }
	        }
	        
	        if( i == (s.length()-1) ) {
	        	char  ch = s.charAt(i);
	        	if(!stack.isEmpty()){
                    if(   (ch+32) == stack.peek()
                       || (ch-32) == stack.peek() ) {
                        stack.pop();
                    } else
                    	stack.push(ch);
                } else
                	stack.push(ch);
	        }
	        
	       
	        
	        return rev(stack, new StringBuilder()).toString();
	    }

	private StringBuilder rev(Deque<Character> stack, StringBuilder stringBuilder) {
		// TODO Auto-generated method stub
		
		if(stack.size() == 0)
			return stringBuilder;
		
		if(stack.size() == 1)
			return stringBuilder.append(stack.pop());
		
		char ch = stack.pop();
		return rev(stack,stringBuilder).append(ch);
		
	}

}
