package test.app.stack;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {

	public static void main(String[] args) {
		System.out.println( new BasicCalculator().calculate("1 + 1"));

	}
	
	public int calculate(String s) {
	   
       Deque<String> stack = new LinkedList<>();
       for( int i=0;i<s.length();i++ ){
    	   
    	   char c = s.charAt(i);
    	   
    	   if(' '==c ) {
    		   continue;
    	   }
    	   
    	   if('('==c || '+'==c || '-'==c ) {
    		   stack.push(String.valueOf(c));
    		   continue;
    	   }
    	   
    	   if(c==')') {
    		   String val = null;
    		   while( !stack.isEmpty() ) {
    			   String item = stack.pop();
    			   if( "(".equals(item) ) {
    	    		   break;
    	    	   }
    			   val = item;
    		   }
    		   
    		   if( val == null )
    			   continue;
    		   
    		   processStack( Integer.valueOf(val), stack);
    	   } else {
    		   int h=i;
    		   while(i<s.length() && Character.isDigit(s.charAt(i))) {
    			   i++;
    		   }
    		   
    		   processStack( Integer.valueOf(s.substring(h,i)), stack);
    		   i--;
    	   }
       }
       
       while( stack.size() > 1 ) {
    	   stack.pop();
       }

       return Integer.valueOf( stack.pop() );
	}

    public void processStack( int val , Deque<String> stack ){
        if( stack.isEmpty() || "(".equals(stack.peek()) ){
            stack.push(Integer.toString(val));
            return ;
        }
        
        String item = stack.pop();
        if( "-".equals(item) ) {
        	val = -val;
        } else if ( !"+".equals(item) ) {
        	val +=  Integer.valueOf(item);
        }
        
        processStack(val, stack);
    }

}
