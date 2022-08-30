package test.app.greedy;

public class ShortestUnsortedContinousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 20,30,40,50,60,35,70,80,90,10 };
		System.out.println( new ShortestUnsortedContinousSubArray().findUnsortedSubarray(nums));
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
