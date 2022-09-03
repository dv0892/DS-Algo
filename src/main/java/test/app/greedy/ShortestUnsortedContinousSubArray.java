package test.app.greedy;

import java.util.Arrays;

public class ShortestUnsortedContinousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,6,4,8,10,9,15 };
		System.out.println( new ShortestUnsortedContinousSubArray().findUnsortedSubarray_Other(nums));
		System.out.println( new ShortestUnsortedContinousSubArray().findUnsortedSubarray(nums));
	}
	
	
	public int findUnsortedSubarray_Other(int[] nums) { 
		int[] sorted = nums.clone();
		Arrays.sort(sorted);
		
		int l=0 , r = sorted.length-1;
	    
		while( l < sorted.length && sorted[l] == nums[l] )
			l++;
		
		while( r >= 0 && sorted[r] == nums[r] )
			r--;
		
		return l > r ? 0 : r-l+1;
	
	
	}
	
	public int findUnsortedSubarray(int[] nums) {
		if( nums.length == 1 )
			return 0;
		
		if( nums.length == 2)
			return nums[0] > nums[1] ? 2 : 0;
			
		int r = 1, n = nums.length,l=0, max = 0 , ans = 0;
		while( r < n ) {
			if( nums[r] < nums [r-1] ) {
				
				int i = r-2;
				while( i>=0 && nums[i] > nums[r] )
					i--;
				
				l = i ;
				max = nums[r-1];
				ans = r-l;
				break;
			}
			r++;
		}
		
		while( ++r < n ) {
			if( nums[r] >= max ) {
				max = Math.max(max, nums[r]);
				continue;
			}
			
			while( l>=0 && nums[r] < nums[l] )
				l--;
			
			ans = r-l;
		}
		
		return ans;
			
    }

}
