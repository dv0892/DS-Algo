package test.app.dp;

public class CountSortedVowelString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new CountSortedVowelString().countVowelStrings(4));
	}
	
	public int countVowelStrings(int n) {
		 int[][] dp = new int[6][n];
	        
	        int r=4,sum=0;
	        while( r >=0 ) {
	        	int c = 0;
	        	while( c < n) {
	        		if( c == 0 )
	        			dp[r][c] = 1;
	        		else
	        			dp[r][c] = dp[r+1][c] + dp[r][c-1];
	        		
	        		c++;
	        	}
	        	
	        	sum += dp[r][n-1];
	        	r--;
	        }
	        
	        return sum ;
    }

}
