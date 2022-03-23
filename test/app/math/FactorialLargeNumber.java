package test.app.math;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FactorialLargeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial(ThreadLocalRandom.current().nextInt(100));
	}
	
	public static void factorial(int N) {
		
		//Since factorial numbers increase very rapidly
		// and easily go out of int and long limits.
		// We can use a array to store individual digits to
		// that make the whole number.
		// Though a linked-list would be more appropriate here
		// and efficient one. Will cover that once i reach that topic.
		
		int[] res = new int[5000] ;
		int resSize = 1;res[0]=1;
		
		for(int f = 2; f <= N; f++ ) {
			resSize = multiply(f,res,resSize);
		}
		
		System.out.print(N + " : "+ Arrays.toString(res));
	}

	private static int multiply(int f, int[] res, int resSize) {
		
		int carry = 0,i=0;
		for( ; i<resSize;i++) {
			int t = res[i]*f + carry;
			res[i] = t%10;
			carry  = t/10; 
		}
		
		if(carry != 0) {
			while(carry!=0) {
				res[i++] = carry%10;
				carry /= 10;
			}
		}
		
		return i;
	}

}
