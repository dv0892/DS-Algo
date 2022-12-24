package test.app.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		System.out.println( new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1,3,1,1,3}));
	}

	
	public int maxProfit(int[] prices) {
		int[][] dp = new int[2][prices.length];
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		
        int ans = maxProfit(0, 1, prices,dp);
        
        System.out.println( Arrays.toString(dp[0]));
        System.out.println( Arrays.toString(dp[1]));
        
        return ans ;
    }
	
	public int maxProfit(int i , int buy , int[] prices, int[][] dp) {
        if( i >= prices.length )
        	return 0;
        
        if( dp[buy][i] != -1 ) 
        	return dp[buy][i];
        
        int x = 0;
        if( buy == 1 ) {
        	int b = -prices[i] + maxProfit(i+1, 0 , prices,dp);
        	int nb =  maxProfit(i+1, 1 , prices,dp);
        	x = Math.max(b, nb);
        } else {
        	int s = prices[i] + maxProfit(i+2, 1 , prices,dp);
        	int ns =  maxProfit(i+1, 0 , prices,dp);
        	x = Math.max(s, ns); 
        }
        
        return dp[buy][i] = x;
    }

}
