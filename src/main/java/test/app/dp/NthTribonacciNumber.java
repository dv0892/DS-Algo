package test.app.dp;

public class NthTribonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 37;
		System.out.println( new NthTribonacciNumber().tribonacci(n));
		int[] dp = new int[n+1];
		
		System.out.println( new NthTribonacciNumber().tribonacci(dp, n));
		
	}
	
	public int tribonacci(int n) {
        
		if( n <= 0 )
			return 0;
		
		if( n==1 || n==2)
			return 1;
		
		return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3); 
    }
	
	
	public int tribonacci(int[] dp , int n) {
        // Using Top DOWN Approach
		if( n <= 0 )
			return 0;
		
		if( n==1 || n==2)
			return 1;
		
		if( dp[n] != 0)
			return dp[n];
		
		dp[n] = tribonacci(dp,n-1) + tribonacci(dp,n-2) + tribonacci(dp,n-3); 
		
		return dp[n];
    }

}
