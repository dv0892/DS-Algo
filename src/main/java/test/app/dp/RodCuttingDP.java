package test.app.dp;

import java.util.ArrayList;
import java.util.List;



public class RodCuttingDP {

	public RodCuttingDP(int rodLen) {
		dp = new int[rodLen+1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rodLen = 7;
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDP(rodLen));
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDPUsingBottomUp(rodLen));
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDPUsingBottomUpWithCuts(rodLen));
	}
	
	int[] pricetable = { 0,1,5,8,9,10,17,17,20,24,30 };
	
	int[] dp ;
	
	/*
	 * Thid is DP using Top-down approach. As we moving from Bigger problems to smaller problems.
	 * Caching the result of smaller problems.
	 */
	
	
	
	public int findMaxRevenueImprovedByDP(  int rodLength ) {
		if( rodLength == 0 )
			return 0;
		
		if( dp[rodLength] > 0 )
			return dp[rodLength];
		
		int max = Integer.MIN_VALUE;
		int choice = 1;
			
		while( choice <= rodLength ) {
			max = Math.max(max, pricetable[choice] + findMaxRevenueImprovedByDP( rodLength - choice++ ));
		}
		
		
		dp[rodLength] = max;
		return dp[rodLength];
	}
	
	
	
	public int findMaxRevenueImprovedByDPUsingBottomUp(  int rodLength ) {
		if( rodLength == 0 )
			return 0;
		
		dp[0] = 0;
		
		int i = 1;
		while ( i <= rodLength) {
			//Here we are solving the smaller sub-problems first moving in bottom up fashion.
			int j=1, max = Integer.MIN_VALUE;
			while ( j <= i) {
				max = Math.max(max, pricetable[j] + dp[i-j] );
				j++;
			}
			dp[i++] = max;
		}
		return dp[rodLength];
	}
	
	public int findMaxRevenueImprovedByDPUsingBottomUpWithCuts(  int rodLength ) {
		if( rodLength == 0 )
			return 0;
		
		dp[0] = 0;
		List<List<Integer>> optimalCuts = new ArrayList<> ();
		optimalCuts.add(new ArrayList<>());
		
		int i = 1;
		while ( i <= rodLength) {
			//Here we are solving the smaller sub-problems first moving in bottom up fashion.
			int j=1, max = Integer.MIN_VALUE;
			List<Integer> cuts = new ArrayList<> ();
			
			while ( j <= i) {
				if( (pricetable[j] + dp[i-j]) > max ) {
					max = (pricetable[j] + dp[i-j]);
					cuts.clear();
					cuts.add(j);
					cuts.addAll(optimalCuts.get(i-j));
				}
				j++;
			}
			
			optimalCuts.add(cuts);
			dp[i++] = max;
		}
		
		System.out.println( "Optimal Cuts are" + optimalCuts.get(optimalCuts.size()-1));
		
		return dp[rodLength];
	}


}
