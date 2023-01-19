package test.app.dp;

public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new IntegerBreak().integerBreak(2));
	}
	
	
	public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = 1;
        
        int max = Integer.MIN_VALUE;
        for( int r=1;r<=n ;r++) {
        	for( int c=1;c<=r;c++) {
        		if( c == 1 ) {
        			dp[r][c] = r;
        			continue;
        		} else if ( r == c ) {
        			dp[r][c] = 1;
        		} else {
        			int p = 1, nr = r-1;
        			while( nr >= (c-1) ) {
        				dp[r][c] = Math.max(dp[r][c], p * dp[nr][c-1]);
        				p++;nr--;
        			}
        		}
        		max = Math.max(dp[r][c], max);
        	}
        }
        
        return max;
    }

}
