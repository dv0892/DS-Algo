package test.app.dp;

public class MaximumScoreFromPerformingMultipleOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-5,-3,-3,-2,7,1};
		int[] multipliers = {-10,-5,3,4,6};
		
		MaximumScoreFromPerformingMultipleOperations obj = new MaximumScoreFromPerformingMultipleOperations();
		System.out.println( obj.maximumScore_backtracking(nums, multipliers, 0, nums.length-1, 0) );
		System.out.println( obj.maximumScore_dp(nums, multipliers)  );
		System.out.println( obj.maximumScore_dp_1d(nums, multipliers)  );
	}
	
	
	public int maximumScore_dp_1d (int[] nums, int[] multipliers ) {
        
		
		/*
		 *  Need to apply DP since lot of overlapping sub-problems and optimal solution of sub-problem will form the optimal solution of parent problem.
		*/
		
		int n = nums.length;
		int m = multipliers.length;
		int[] dp = new int[m+1];
		
		int multiplier = multipliers[m-1];
		int s = 0 , e = n-m; 
		
		while( m > 0) {
			
			multiplier = multipliers[m-1];
			s = 0 ; e = n-m; 
			
			for( int c = 0 ; c < m ; c++ ) {
				dp[c] = Math.max( multiplier*nums[s] + dp[c+1], multiplier*nums[e] + dp[c]);
				s++; e++;
			}
			m--;
			
		}
        
        return dp[0];
    }
	
	
	public int maximumScore_dp (int[] nums, int[] multipliers ) {
        
		
		/*
		 *  Need to apply DP since lot of overlapping sub-problems and optimal solution of sub-problem will form the optimal solution of parent problem.
		*/
		int[][] dp = new int[multipliers.length+1][multipliers.length+1];
		int n = nums.length;
				
		for( int r = multipliers.length-1 ; r >= 0 ; r--) {
			int multiplier = multipliers[r];
			
			int s = 0 , e = n-1-r; 
			for( int c = 0 ; c <= r ; c++ ) {
				dp[r][c] = Math.max( multiplier*nums[s] + dp[r+1][c+1], 
						             multiplier*nums[e] + dp[r+1][c] );
				s++; e++;
			}
				
		}
        
        return dp[0][0];
    }
	
	
	public int maximumScore_backtracking (int[] nums, int[] multipliers ,int s , int e , int i ) {
        
		// TLE WITH LARGE INPUTS
		/*
		 *  Need to apply DP since lot of overlapping sub-problems and optimal solution of sub-problem will form the optimal solution of parent problem.
		*/
		if( i == multipliers.length )
        	return 0;
        
        
        int ans1  = multipliers[i] * nums[s] + maximumScore_backtracking ( nums , multipliers , s+1 ,e , i+1  );
        
        int ans2  = multipliers[i] * nums[e] + maximumScore_backtracking ( nums , multipliers , s ,e-1 , i+1  );
		
        
        return Math.max(ans1, ans2);
    }
	
	
	
	

}
