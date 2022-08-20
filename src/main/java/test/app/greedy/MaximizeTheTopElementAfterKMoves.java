package test.app.greedy;

public class MaximizeTheTopElementAfterKMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maximumTop(int[] nums, int k) {
		
		/*
		 * Finding the Edges cases was trickiest
		 */
        
        if( nums.length==1 && k%2==1)
            return -1;
        
        if( k==0 || (nums.length==1 && k%2==0) )
            return nums[0];
        
        
        int i = 0 , n = nums.length , max = -1;
        while ( i<n && k>1 ){
            max = Math.max( max, nums[i] );
            i++; k--;
        }
        
        if( i == n)
            return Math.max( max, -1) ;
        else
            return Math.max( max, ((i+1)==n) ? -1 : nums[i+1] );
    }

}
