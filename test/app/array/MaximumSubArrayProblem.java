package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		/*ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(nums));
		System.out.println(new MaximumSubArrayProblem().maxSubArray(A));*/
		
		System.out.println(Arrays.toString( new MaximumSubArrayProblem().maxSubArrayRes(nums)));
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

	
}
