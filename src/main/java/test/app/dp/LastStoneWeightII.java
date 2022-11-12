package test.app.dp;

import java.util.Arrays;

public class LastStoneWeightII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LastStoneWeightII().lastStoneWeightII( new int[]{21,33,31,26,40} ) );
	}
	
	
	public int lastStoneWeightII(int[] stones) {
        // 0-1 Knapsack problem 
		// Based on the observation that ultimately all the stones can be destroyed to zero or last stone weight should
		// be returned if that is the only one left.
		
		// Stones [a,b,c,d,e,f]
		// ulitmately smashing stones as (a+b+c)-(d+e+f) = D. we must try to minimized D to zero
		/*
		 * x - y = d
		 * x = d + y
		 * 
		 * S = x + y
		 * S = d + 2y
		 * S - 2y = d
		 * 
		 * We can find y and try to maximize it , to minimize d.
		 * 
		 */
		
		Arrays.sort(stones);
		int S = 0,n=stones.length;
		for( int s : stones )
			S += s;
		
		int[][] dp = new int[n+1][S/2+1];
		for( int s = 1; s<=n ; s++ ) {
			for( int sum=1;sum<=S/2;sum++) {
				if( stones[s-1] <= sum ) {
					dp[s][sum] = Math.max(dp[s-1][sum],stones[s-1] +  dp[s-1][ sum - stones[s-1]]);
				} else {
					dp[s][sum] = dp[s-1][sum];
				}
			}
		}
		
		
		System.out.println(S/2);
		for(int[] a : dp )
			System.out.println(Arrays.toString(a));
		
		return  S - 2*dp[n][S/2];
    }

}
