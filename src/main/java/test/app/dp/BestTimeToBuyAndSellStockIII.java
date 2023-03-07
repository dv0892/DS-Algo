package test.app.dp;

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		System.out.println( new BestTimeToBuyAndSellStockIII().maxProfit(new int[] {3,3,8,5,6,7,6,5,10}));
	}
	
	
	    public int maxProfit_FinalSolutionWithDP(int[] prices) {
	        int len  = prices.length;
	        int[][] dp_right = new int[2][len];
	        int[][] dp_left  = new int[2][len];

	        dp_right[0][len-1] = prices[len-1];
	        dp_right[1][len-1] = 0;
	        for( int i=len-2;i>=0;i-- ) {
	            dp_right[1][i] = Math.max(dp_right[1][i+1],dp_right[0][i+1] - prices[i]);
	            dp_right[0][i] = Math.max(dp_right[0][i+1],prices[i] ) ;
	        }


	        dp_left[0][0] = prices[0];
	        dp_left[1][0] = 0;
	        for( int i=1;i<len;i++ ) {
	            dp_left[1][i] = Math.max(dp_left[1][i-1],prices[i] - dp_left[0][i-1]);
	            dp_left[0][i] = Math.min(dp_left[0][i-1],prices[i] ) ;
	        }   
	        //System.out.println(Arrays.toString(dp[2]));

	        int maxProfit = 0;
	        for( int i=0;i<prices.length;i++) {
	            maxProfit = Math.max( maxProfit, dp_left[1][i] + ( (i+1) < prices.length ? dp_right[1][i+1] : 0 ) );
	        }   
	        
	        return maxProfit;
	    }
	
	
	public int maxProfit(int[] prices) {
        int len  = prices.length;
        int[][] dp = new int[3][len];
        dp[0][len-1] = prices[len-1];
        dp[1][len-1] = prices[len-1];
        dp[2][len-1] = dp[1][len-1] - dp[0][len-1];

        for( int i=len-2;i>=0;i-- ) {
            dp[0][i] = Math.min(prices[i],dp[0][i+1]);
            dp[2][i] = dp[1][i+1] - dp[0][i];
            dp[1][i] = Math.max(prices[i],dp[1][i+1]);
        }

        System.out.println(dp[0]);
        System.out.println(dp[1]);
        System.out.println(dp[2]);

        int maxProfit = 0;
        for( int i=0;i<prices.length;i++) {
            int bp=prices[i];

            for( int j=i+1;j<prices.length;j++) {
                    if( prices[j] >= bp ){
                        maxProfit = Math.max( maxProfit, (prices[j] - bp) + ( (j+1) < prices.length ? dp[2][j+1] : 0 ) );
                    }   
            }
        }


        return maxProfit;
    }

}
