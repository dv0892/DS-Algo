package test.app.search;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.println( new MaxConsecutiveOnesIII().longestOnes(nums, 3));
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

}
