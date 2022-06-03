package test.app.search;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println( new MaxConsecutiveOnesIII().longestOnesOptimized(nums, 10));
	}
	
	public int longestOnes(int[] nums, int k) {
        
		// This is having O(n^2) complexity.
		// Needs to optimized
		
		int ans = Integer.MIN_VALUE;
        for( int i=0;i<nums.length ;i++) {
        	int ct = 0,f=k;
        	for (int j=i; j<nums.length;j++) {
        		
        		if( nums[j] == 0 ){
        			if( f <= 0)
        				break;
        			f--;
        		}

        		ct++;
        	}
        	ans = Math.max(ans, ct);
        }
        
        return ans;
    }
	
public int longestOnesOptimized(int[] nums, int k) {
        
		// This is having O(n^2) complexity.
		// Needs to optimized
	
		int s=0,e=0,f=k;
		
		//exhausting f
		while( e < nums.length ) {
			if( nums[e] == 0 ){
    			if( f == 0)
    				break;
    			f--;
    		}
			e++;
		}
		
		int ans = Integer.MIN_VALUE;
		
		// Now start traversing windows having k flipped zero's
		while( e < nums.length ) {
			if( nums[e] == 0 ){
				ans = Math.max(ans, e - s );
				
    			if( nums[s] == 1 ) {
    				while( nums[++s] == 1 );
    			}
    			s++;
    		} 
    			e++;
		}
		
        return Math.max(ans, e-s );
    }

}
