package test.app.greedy;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  {3,2,1,0,4};
		
		System.out.println( new JumpGame().canJump(nums) );
	}
	
	public boolean canJump_Greedy(int[] nums) {
        int reach = 0;
        for( int i=0; i<nums.length ; i++){
            if( reach < i ) return false;
        	reach = Math.max(i + nums[i], reach);
        }
        
        return true;
    }
	
	public boolean canJump(int[] nums) {
        boolean[] dp =  new boolean[nums.length];
        dp[dp.length-1] = true;
        
        int n = nums.length;
        for( int i=n-2; i>=0 ; i--){
            int jumps = i+nums[i];
            int j = i  ;
            while( j<n && j<=(jumps) ){
                    dp[i] |= dp[j] ;
                    j++;
                if( dp[i] ) break;
            }
        }
        
        return dp[0];
    }

}
