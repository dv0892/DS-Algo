package test.app.greedy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -9, -9, -7, -6, -3};
		System.out.println( new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(arr, 8));
	}
	
	 public int largestSumAfterKNegations(int[] nums, int k) {
	        Arrays.sort(nums);
	        
	        int sum = 0;    
	        for( int n : nums )
	            sum += n;
	        
	        int i = 0;
	        while( k > 0) {
	            if( nums[i] < 0){
	                if( ( (i+1)==nums.length ) ) {
	                	if( k%2 == 1) {
	                		nums[i] = - nums[i];
	 	                    sum += ( nums[i]*2 );
	                    }
	                    break;
	                } else if ( nums[i+1] > 0 ) {
	               		 nums[i] = - nums[i];
	                     sum += ( nums[i]*2 ); 
	                    // Arrays.sort(nums);
	                     if( nums[i+1] < nums[i] )
	                    	 i++;
                     	// This means we have made all the negative mumbers positive and still k is remaining .
                        //Now we will apply K on smallest positive number
            	    } else{
	                    nums[i] = - nums[i];
	                    sum += ( nums[i]*2 );
	                    i++;
	                }
	                k--;
	                
	            } else {
	                if( k%2 == 1 )
	                    sum -= (((nums[i])*2) );
	                
	                break;
	            } 
	        }
	        
	        return sum;
	    }

}
