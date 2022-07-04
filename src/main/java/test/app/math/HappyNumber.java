package test.app.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new HappyNumber().isHappy(7));
	}
	
	public boolean isHappy(int n) {
	        
	        Set<Integer> set = new HashSet<>();
	        
	        while(true){
	            if( n == 1 )
	                return true;
	            
	            if ( set.contains(n) )
	                break;
	            
	            set.add(n);
	            n = sumOfSquareDigits(n);
	            
	        }
	        
	        return false;
	        
	    }
    
    public int sumOfSquareDigits(int n) {
        int sum = 0;
        while(n > 0){
            int d = n%10;
            sum += d*d;
            n /= 10;
        }
        
        return sum;
    }

}
