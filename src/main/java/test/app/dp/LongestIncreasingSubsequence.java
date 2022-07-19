package test.app.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums,0);
    }
    
    public int lengthOfLIS(int[] nums , int i ) {
        if( i < 0 || i >= nums.length )
            return 0;
        
        int max = 1;
        while( i < nums.length-1 ){
            for( int j = i+1; j < nums.length ;j++) {
                if( nums[j] > nums[i] ){
                    max = Math.max( max , 1 + lengthOfLIS(nums,j));
                }
            }
            i++;
        }
        
        return max;
    }
    
    
    public int lengthOfLISBottomUp(int[] nums ) {
       
    	/*
    	 *  Start with the base case when there is only 1-element
    	 */
    	
    	 int[] dp = new int[nums.length];
         int max = Integer.MIN_VALUE;

         
         int i=nums.length-1;
         while( i >= 0 ) {
             dp[i]=1;
         	for( int j = i+1; j < nums.length ;j++) {
                 if( nums[i] < nums[j] )
                   dp[i] = Math.max( dp[i],1 + dp[j] ) ;
             }
             max = Math.max(max,dp[i]);
         	i--;
             
         } 
         		
         
         
         return max;
    }

}
