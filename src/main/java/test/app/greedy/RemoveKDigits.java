package test.app.greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new RemoveKDigits().removeKdigits("10200", 1));
		System.out.println( new RemoveKDigits().removeKdigits_Max("10200", 1));
		
		
	}
	
	public String removeKdigits(String num, int k) {
	    
        Deque<Integer> stack = new LinkedList<>();
        int i=0;
        while( i<num.length() && k>0 ) {
            int digit = num.charAt(i)-48;
            
            if ( !stack.isEmpty() && digit < stack.peek()){
                stack.pop(); k--;  
            } else {
                
                if( digit != 0 || ( digit == 0 && !stack.isEmpty() ) )
                      stack.push(digit);
                i++;
            
            }
            
        }
        
        while(!stack.isEmpty() && k-- > 0)
           stack.pop();
        
        
        if(stack.isEmpty() )
            while ( i < num.length() && num.charAt(i) == '0')
                i++;
        
        
        StringBuilder res = new StringBuilder();
        for( int d : stack )
            res.append(d);
        
        res.reverse();
        res.append(num.substring(i));
        
        if( res.length() == 0)
        	res.append('0');
        
        return res.toString();
    }
	
	
public String removeKdigits_Max(String num, int k) {
	    
        Deque<Integer> stack = new LinkedList<>();
        int i=0;
        while( i<num.length() && k>0 ) {
            int digit = num.charAt(i)-48;
            
            if ( !stack.isEmpty() && digit > stack.peek()){
                stack.pop(); k--;  
            } else {
                
                if( digit != 0 || ( digit == 0 && !stack.isEmpty() ) )
                      stack.push(digit);
                i++;
            
            }
            
        }
        
        while(!stack.isEmpty() && k-- > 0)
           stack.pop();
        
        
        if(stack.isEmpty() )
            while ( i < num.length() && num.charAt(i) == '0')
                i++;
        
        
        StringBuilder res = new StringBuilder();
        for( int d : stack )
            res.append(d);
        
        res.reverse();
        res.append(num.substring(i));
        
        if( res.length() == 0)
        	res.append('0');
        
        return res.toString();
    }

	
}
