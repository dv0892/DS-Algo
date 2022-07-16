package test.app.dp;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 45;
		//System.out.println( new ClimbStairs().climbStairs(n));
		
		int[] dp = new int[n+1];
		System.out.println( new ClimbStairs().climbStairsBottomUp(n));
	}
	
	
	public int climbStairs(int n) {
	/*
	 * Here the individual recursive calls are too much 
	 * repetitive work. Since they are doing repetitive work we store the subproblems result.
	 * Here we are kind of using backtracking to get all the distinct paths.
	 * First we are climbing the stairs using 1 step and then combing back to make 2 step and calulating the further pathes from there
	 * 
	 * 
	 */
	   if( n < 0 )
		   return 0;
	   
       if ( n == 0 )
    	   return 1;
       
        
       return climbStairs(n-1) + climbStairs(n-2);
    }
	
	public int climbStairs(int[] dp, int n) {
		/*
		 * Here the individual recursive calls are too much 
		 * repetitive work. Since they are doing repetitive work we store the subproblems result in 
		 * TOP-DOWN Approach
		 */
		   if( n < 0 )
			   return 0;
		   
	       if ( n == 0 )
	    	   return 1;
	       
	       if (dp[n] != 0 )
	    	   return dp[n];
	       
	        
	       int ways = climbStairs(dp,n-1) + climbStairs(dp,n-2);
	       dp[n] = ways;
	       
	       return dp[n];
	}
	
	
	public int climbStairsBottomUp( int n) {
		/*
		 * 
		 * BOTTOM-UP Approach of Climb Stairs
		 * Solving the smaller problems first.
		 */
		  if( n == 0 )
			  return 0;
		
		  int[] dp = new int[n+1];
	      dp[0] = dp[1] = 1;
	      
	       int i = 2;
	       while ( i <= n) {
	    	   dp[i] = dp[i-1] + dp[i-2];
	    	   i++;
	       }
	       
	       return dp[n];
	}

}
