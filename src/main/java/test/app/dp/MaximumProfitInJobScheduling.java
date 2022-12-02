package test.app.dp;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = new MaximumProfitInJobScheduling().jobScheduling( new int[]{1,2,3,4,6} ,new int[]{3,5,10,6,9},new int[]{20,20,100,70,60} );
		
		System.out.println( res );
	}
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		
		int len = startTime.length;
        int[][] jobs = new int[len][3];
        
        for(int j=0;j<len;j++) {
        	jobs[j] = new int[] {startTime[j],endTime[j],profit[j]};
        }
        
        
        return jobSchedulingUsingDP(jobs);
    }
	
	public int jobSchedulingUsingBacktracking( int[][] jobs, int profit, int index , int endTime ) {
        if( index == jobs.length )
       	return profit;
       
       int max = profit;
       while( index < jobs.length ) {
       	if( jobs[index][0] >= endTime ) {
       		max = Math.max( max , jobSchedulingUsingBacktracking(jobs, profit + jobs[index][2] , index+1, jobs[index][1]  ) );
       	}
       	
       	index++;
       }
       
       return max;
   }
	
	public int jobSchedulingUsingDP( int[][] jobs ) {
       
	   int[] dp = new int[jobs.length];
	   Arrays.sort(jobs,(j1,j2) -> Integer.compare(j1[0], j2[0]) );
	   int res = Integer.MIN_VALUE;
	   
	   for( int i=jobs.length-1;i>=0;i--) {
		   int[] currjob = jobs[i];
		   int max = currjob[2];
		   
		   // we are doing too much extra work here, should be reduced.
		   int j = binarySearch(jobs, i+1, jobs.length-1, currjob[1]) ;
		   
		   // Find the upper bound also. That is least elements that should be processed
		   int upperBound = Integer.MAX_VALUE;
		   for( ;j<jobs.length && jobs[j][0] < upperBound ;j++) {
				 max = Math.max( max , currjob[2] + dp[j] );
				 upperBound = Math.min(upperBound, jobs[j][1]);
		   }
		   
		   dp[i] = max;
		   res = Math.max(dp[i], res);
	   }
		
       return res;
   }
	
   public int binarySearch( int[][] jobs , int s , int e , int startTime ) {
	   while( s <= e ) {
		   int mid = (s+e)/2;
		   
		   if( jobs[mid][0] >= startTime ) {
			   e = mid-1; 
		   } else
			   s = mid + 1;
	   }
	   
	   return e+1;
   }

}
