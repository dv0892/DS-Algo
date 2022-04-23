package test.app.array;

import java.util.Arrays;

public class MinimumDiffBetweenHighestAndLowestOfKScores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,4,1,7};
		System.out.println( new MinimumDiffBetweenHighestAndLowestOfKScores().minimumDifference(nums, 1));
	}
	
	public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        if( k == nums.length )
            return nums[nums.length-1] - nums[0];
            
        
        int n = nums.length, minDiff = Integer.MAX_VALUE;
        for( int i=0; i <= (n - k) ;  i++) {
            minDiff = Math.min(minDiff , nums[i+k-1] - nums[i] );
        }
            
        return minDiff;
    }

}
