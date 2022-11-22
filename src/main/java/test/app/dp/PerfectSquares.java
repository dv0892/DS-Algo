package test.app.dp;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new PerfectSquares().numSquares(16));
	}
	
	
	public int numSquares(int n) {
        if( n < 4 )
        	return n;
        	
        int[] dp = new int[n+1];
        dp[1]=1;
        
        int diff=3,oddDiff=1;
        for( int i=2;i<=n;i++) {
        	
        	
        	if( oddDiff==diff) { //If it is a perfect square
        		dp[i]=1;
        		oddDiff=1;
        		diff+=2;
        	} else {
        		int minPerfSq=1,tempDiff=3;     		
        		int min = Integer.MAX_VALUE;
        		
        		while(minPerfSq <= (i)) { // Just check all the perfect squares till 1
        			min = Math.min(min, dp[i-minPerfSq]);
        			minPerfSq += tempDiff;
        			tempDiff+=2;
        	    }
        		
        		dp[i] = min+1;   
        		oddDiff++;
        	}
        }
        
        return dp[n];
    }

}
