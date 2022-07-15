package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {1,2,-1,-2,2,1,-2,1};
		// int[] nums = {-2,1};
		/*ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(nums));
		System.out.println(new MaximumSubArrayProblem().maxSubArray(A));*/
		
		//System.out.println(Arrays.toString( new MaximumSubArrayProblem().maxSubArrayRes(nums)));
		System.out.println( new MaximumSubArrayProblem().maxSubArrayDivideAndConquer(nums, 0, nums.length-1) );
		
	}
	
	public int maxSubArray(final List<Integer> A) {
        int local_max = 0;
        int global_max = Integer.MIN_VALUE;

        for(int el : A){
            local_max  = Math.max(el , el + local_max);
            global_max = Math.max(local_max, global_max) ;
        }

        return global_max;
        
    }
	
	public int maxSubArray1(int[] nums) {
        
	       int runningSum = 0, maxSum = nums[0] ;
	       int s=0,e=0;
	       int sf ,ef ;
	        sf = ef = 0;
	       for( int i=0;i<nums.length; i++ ){
	           
	           if( nums[i] > ( nums[i] + runningSum) ){
	               s = e = i;
	               runningSum = nums[i] ;
	           } else{
	               e++;
	               runningSum += nums[i] ;
	           }
	           
	           if(  runningSum > maxSum ){
	               maxSum =  runningSum ;
	               sf = s;ef = e;
	               
	           }
	           
	       }
	    
	        
	        return maxSum;
	        
	    }
	
	
	public int maxSubArray(int[] nums) {
        
        int t_max , max ;
        t_max = max = nums[0];
        
        for(int i=1;i<nums.length;i++){
            t_max = Math.max(nums[i],nums[i]+t_max);
            max   = Math.max(max,t_max);
        }
        
        return max;
    }
	
	public int[] maxSubArrayRes(int[] nums) {
        
        int t_max , max ;
        t_max = max = nums[0];
        
        int j,k,l,m;
        j = k = l = m = 0;
        
        for(int i=1;i<nums.length;i++){
        	
        	if( ( nums[i] + t_max ) > nums[i] ) {
        		k++;
        	} else {
        		j=k=i;
        	}
        	
            t_max = Math.max(nums[i],nums[i]+t_max);
            
            if(t_max > max) {
            	l = j;
            	m = k;
            }
            
            max   = Math.max(max,t_max);
        }
        
        int[] res = new int[m-l+1];
        
        for( int i=0; l <= m;)
        	res[i++] = nums[l++];
        
        return res;
    }

	public int maxSubArrayDivideAndConquer(int[] nums,int l, int h) {
	 /*
	  * We can also solve the max subarray problem using
	  * Divide and conquer technique.
	  * This is based on the idea :
	  * 1. Max Subarray lies either in left half.
	  * 2. Max Subarray lies either in right half.
	  * 3. It will be a sub-array crossing the midpoint 
	  * 
	  * The  base condition is just one element in array;		
	  */
		
		if( l == h)
			return nums[l];
		
		int m = l + (h-l)/2;
		
		return Math.max(  Math.max(maxSubArrayDivideAndConquer(nums,l,m),maxSubArrayDivideAndConquer(nums,m+1,h)) 
				        , maxSubArrayCrossing(nums,l,m,h));
		
	}

	private int maxSubArrayCrossing(int[] nums, int l, int m, int h) {
		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i=m ; i>=l; i-- ) {
			sum += nums[i];
			if(sum > leftSum)		
				leftSum = sum;
					
		}
		
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i=m+1 ; i<=h; i++ ) {
			sum += nums[i];
			if(sum > rightSum)		
				rightSum = sum;
		}
		
		return leftSum + rightSum;
	}
}
