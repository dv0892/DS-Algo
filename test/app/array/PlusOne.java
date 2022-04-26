package test.app.array;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString( new PlusOne().plusOne( new int[] {1,9,9})));
	}
	
	 public int[] plusOne(int[] digits) {
	        
	        int i = digits.length-1 ;
	        while( i>=0 ){           
	            digits[i]++;  
	            if(digits[i] > 9) {
	                digits[i--] = 0;
	            } else {
	                return digits;
	            }
	        }
	        
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        
	        System.arraycopy(digits, 0, res, 1, digits.length);
	        
	        return res;
	 }

}
