package test.app.dp;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
        
        int max1 = nums.length > 0 ? nums[0] : Integer.MIN_VALUE ;
        int max2 = nums.length > 1 ? nums[1] : Integer.MIN_VALUE ;
        
        int i = 2;
        while( i < nums.length ){
            int newMax = nums[i] + Math.max( max1 , max2 - nums[i-1] ) ;
            max1 = max2;
            max2 = newMax;
            i++;
        }
        
        return Math.max( max1, max2 );
    }
}
