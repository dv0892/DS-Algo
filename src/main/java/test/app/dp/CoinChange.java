package test.app.dp;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new CoinChange().coinChangeBottomUp(new int[] {1,2,5}, 500 ));
	}
	
	public int coinChange(int[] coins, int amount ,int[] dp ) {
        if( amount == 0 )
        	return 0;
        
        if( dp[amount] != 0 )
        	return dp[amount];
        
        int count =  Integer.MAX_VALUE ;
        
        for( int coin : coins ) {
        	if( coin <= amount ) {
        		int t = coinChange(coins, amount - coin ,dp ); 
        		if( t >= 0 )
        			count = Math.min( 1 + t,  count);
        	}
        }
        
        dp[amount] = count == Integer.MAX_VALUE ? -1 : count;
        
        return dp[amount] ;
    }
	
	
	public int coinChangeBottomUp(int[] coins, int amount ) {
		int[] dp = new int[amount+1];
        
       
        int n = 1;
        while( n <= amount ) {
        	
        	int count =  Integer.MAX_VALUE ;
        	for( int coin : coins ) {
        		if( coin <= n ) {
        			int t = dp[n - coin]; 
        			if( t >= 0 )
        			count = Math.min( 1 + t,  count);
        		}
        	}

        	dp[n++] = count == Integer.MAX_VALUE ? -1 : count;
        }
        
        
        return dp[amount] ;
    }

}
