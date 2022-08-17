package test.app.greedy;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,8,4,2,0,6,4,1,8,7,1,7,4,1,4,1,2,8,2,7,3,7,8,2,4,4,5,3,5,6,8,5,4,4,7,4,3,4,8,1,1,9,0,8,2};
		System.out.println( new JumpGameII().jump(nums));
	}

	public int jump(int[] nums) {
		
		if( nums.length == 1 )
			return 0;
		
		int n = nums.length-1;
		int s = 0 , count = 0 ;
		
		while( true ) {
			
			int t = Math.min(n, s + nums[s]);
			if ( t == n ) 
				return count + 1;
			
			int i = s , j = t, t1 = Math.min(n,t+nums[t]) , max_i = t;
			while( ++i < j ) {
				if ( ( Math.min(n,i+nums[i]) ) > t1 ) {
					max_i = i;
					t1 = Math.min(n,i+nums[i]);
				}
			}
			count++;
			s = max_i ;
		}
    }
}
