package test.app.dp;

public class LongestMaximumSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,101,2,3,100,4,5}; 

		System.out.println( new LongestMaximumSubsequence().longestMS(nums));
		System.out.println( new LongestMaximumSubsequence().longestMSBottomUp(nums));
	}
	
	public int longestMS( int[] nums ) {
		return longestMS(nums, 0);
	}
	
	public int longestMS( int[] nums ,int i ) {
		if( i < 0 || i == nums.length )
			return 0;
		
		int maxsum = nums[i];
		while( i < nums.length-1 ) {
		   for ( int j=i+1; j<nums.length ;j++ ) {
			   if( nums[j] > nums[i] )
				   maxsum = Math.max(nums[i] + longestMS(nums, j), maxsum);  
		   }
		   
		   i++;
		}
		
		return maxsum;
	}
	
	
	public int longestMSBottomUp( int[] nums ) {
		
		int[] dp = new int[nums.length];
		int max = Integer.MIN_VALUE;
		
		int i = nums.length-1;
		while(i >= 0) {
			dp[i] = nums[i];
			int j = i+1;
			while( j < nums.length ) {
				if( nums[i] < nums[j] )
				 dp[i] = Math.max(dp[i], nums[i] + dp[j]);
				
				j++;
			}
			
			max = Math.max(max, dp[i]);
			i--;
		}
		
		return max;
	}

}
