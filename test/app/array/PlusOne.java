package test.app.array;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	        
	        return res;
	        
	 }

}
