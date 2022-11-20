package test.app.stack;

import java.util.Deque;

public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new BasicCalculatorII().calculate("12-3*4") );
	}
	
	public int calculate(String s) {
		return Integer.valueOf( processStackCleaned (  processStackCleaned(s, '*' ,'/',0 ) ,'+','-',0 ) .trim() );
    }

	
	public String processStackCleaned( String s , char op1 ,char op2 , int fromIndex ){
		    
			char op = op1 ; 
			int index=-1,left=fromIndex,i=fromIndex ;
			
		    while( i < s.length() ) {
		    	if( s.charAt(i) == op1 || s.charAt(i) == op2 ) {
		    		index = i;
		    		op = s.charAt(i);
		    		break;
		    	} else if( s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'  ) {
		    		left = i;
		    	}
		    	i++;
		    }
			
			if( index == -1 )
				return s;
			
			if ( fromIndex == index )
				return processStackCleaned(s,op1,op2,index+1);
			
	        int r=index+1;
	        // accumulate right digits
	        while( r<s.length() && ( s.charAt(r)==' ' || Character.isDigit(s.charAt(r)) ) ){
	        	r++;
	        }
	        String rightOperand = s.substring(index+1,r).replace(" ", "");
	        
	        // left operand not negative -ive        
	        if( s.charAt(left) == '+' || s.charAt(left) == '*' || s.charAt(left) == '/'  ) {
	    		left++;
	    	} else if(Character.isDigit(s.charAt(left)) && (left-1)>=0 && s.charAt(left-1)=='-') {
	    		left--;
	    		fromIndex = Math.min(left, fromIndex);
	    	}
	        String leftOperand  = s.substring(left, index).replace(" ", "");
	      
	        int res = resolve( Integer.valueOf(leftOperand) , Integer.valueOf(rightOperand) , op );
	        
	        String resolved = s.substring(fromIndex, left)  ;
	        
	        if( s.charAt(left)=='-' && resolved.length()>0 && res>=0) {
	        	resolved += "+";
	        }
	        
	        resolved += String.valueOf(res); 
	        resolved += s.substring(r) ; 
	        
	       
	        return processStackCleaned(resolved, op1,op2,fromIndex);
	}

	
	
	 public String processStack( String s , char op1 ,char op2 , int fromIndex ){
	       // GIving TLE
		    int index1 = s.indexOf(op1,fromIndex);
		    int index2 = s.indexOf(op2,fromIndex);
	        
	        char op = op1 ; int index = index1;
	        if( index1==-1 && index2==-1){
	            return s ;
	        } else if( index1 == -1 ) {
	        	index = index2; 
	        	op = op2;
	        } else if( index2 == -1 ) {
	        	
	        } else {
	        	if( index2 < index1 ) {
	        		op = op2;
	        		index = index2;
	        	}
	        }
	        

	        
	        int l = index-1,r=index+1;
	        
	        // accumulate left digits
	        while( l>-1 && ( s.charAt(l)==' ' || Character.isDigit(s.charAt(l)) ) ){
	        	l--;
	        }
	        
	        // accumulate right digits
	        while( r<s.length() && ( s.charAt(r)==' ' || Character.isDigit(s.charAt(r)) ) ){
	        	r++;
	        }
	        
	        // left operand -ive
	        if( (l>=0 && s.charAt(l) == '-') ) {
	        	l--;
	        	
	        }
	        
	        String left = s.substring(l+1, index).replace(" ", "");
	        String right = s.substring(index+1,r).replace(" ", "");
	        
	        if( left.isEmpty() || right.isEmpty() ) {
	        	return processStack (s,op1,op2,index+1);
	        }
	        
	        int res = resolve( Integer.valueOf(left) , Integer.valueOf(right) , op );
	        String resolved = "";
	        if ( l>-1 )
	        	resolved = s.substring(0,l+1)  ;
	        
	        if( l>=0 && s.charAt(l+1) == '-' && res >= 0) {
	        	resolved += "+";
	        }
	        
	        resolved += String.valueOf(res); 
	        
	        if( r<s.length() ) {
	        	resolved += s.substring(r) ; 
	        }
	       
	        return processStack(resolved, op1,op2,0);
	}
	 
	public int resolve( int operand1 , int operand2 , char operator ) {
		
		switch( operator ) {
			case '+':
				return operand1+operand2;
			case '-':
				return operand1-operand2;
			case '/':
			    return operand1/operand2;
			default:
				return operand1*operand2;
		}
	}

}
