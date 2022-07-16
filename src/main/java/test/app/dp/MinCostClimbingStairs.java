package test.app.dp;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String app = "";
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		
		MinCostClimbingStairs minCost = new MinCostClimbingStairs();
		
		System.out.println( minCost.minCostClimbingStairs(cost, app));
	}
	
	public int minCostClimbingStairs(int[] cost , String approach ) {
        if( approach.equals("BT") ) {
        	return Math.min( minCostClimbingStairsUsingBackTracking(cost,0), minCostClimbingStairsUsingBackTracking(cost,1) );
        } else if ( approach.equals("TopDownDP") ) {
        	int[] dp = new int[cost.length];
        	return Math.min( minCostClimbingStairsUsingTopDownDP(dp,cost,0), dp[1]);
        } else {
        	return minCostClimbingStairsUsingBottomUp(cost);
        }
       
    }
	
	
	public int minCostClimbingStairsUsingBackTracking(int[] cost , int i ) {
        
		// Here we are using Backtracking to try all combinations and solving all the sub-problems
		// repetitively. we can cache the results of sub-problems so that they are solved only once.
		
		if ( i == cost.length )
			return 0;
		
		if ( i > cost.length )
			return 1;
		
		int cost1 =  cost[i] + minCostClimbingStairsUsingBackTracking( cost , i + 1 ) ;
		int cost2 =  cost[i] + minCostClimbingStairsUsingBackTracking( cost , i + 2 ) ;
		
	
		return Math.min(cost1, cost2);
    }
	
	
    public int minCostClimbingStairsUsingTopDownDP(int[] dp , int[] cost , int i ) {
        
		// Here we are using Backtracking to try all combinations and solving all the sub-problems
		// repetitively. we can cache the results of sub-problems so that they are solved only once.
		
		if ( i == cost.length )
			return 0;
		
		if ( i > cost.length )
			return 1;
		
		if( dp[i] != 0 ) 
			return dp[i];
		
		int cost1 =  cost[i] + minCostClimbingStairsUsingTopDownDP(dp, cost , i + 1 ) ;
		int cost2 =  cost[i] + minCostClimbingStairsUsingTopDownDP(dp, cost , i + 2 ) ;
		
		dp[i] = Math.min(cost1, cost2);
	
		return dp[i];
    }
    
    public int minCostClimbingStairsUsingBottomUp( int[] cost ) {
        
		// Here we are using Backtracking to try all combinations and solving all the sub-problems
		// repetitively. we can cache the results of sub-problems so that they are solved only once.
    	/*
    	 * The MOST IMPORTANT THING IN BOTTOM UP DP is HOW TO COMBINE THE RESULT OF CHILD SUBPROBLEMS TO
    	 * CREATE RESULT FOR PARENT SUBPROBLEM
    	 */
    	
    	/*
    	 * We can actually further optimize this by not taking a dp array
    	 * and using two variables instead which will hold the two nearest min costs
    	 */
		
    	int length = cost.length;
		/*int[] dp = new int[length];
    	
		dp[length-1] = cost[length-1];
    	dp[length-2] = cost[length-2];
    	
    	int i = length-3;
    	while( i>=0) {
    		dp[i] = cost[i] + Math.min( dp[i+1] , dp[i+2] );
            i--;
    	}
	
		return Math.min(dp[0], dp[1]);*/
    	
    	int minCost2 = cost[length-1];
    	int minCost1 = cost[length-2];
    	
    	length -= 3;
    	while( (length)>=0) {
    		int temp = minCost1;
    		minCost1 = cost[length] + Math.min( minCost1 , minCost2 );
    		minCost2 = temp;
            
    		length--;
    	}
    	
    	return Math.min(minCost2, minCost1);
    	
    }


}
