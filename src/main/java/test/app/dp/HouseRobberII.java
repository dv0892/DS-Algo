package test.app.dp;

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rob(int[] nums) {
		
		/*
		 * This is a similar problem to House Robber except Array is circular.
		 * When we would reach the last house to rob, there won't be any way to find whether the max answer 
		 * that is available now contains the info whether the first house is robbed.
		 * So we would do two passes of the array first skipping the first element and then skipping the last element.
		 */
        
        int max1 = nums.length > 0 ? nums[0] : Integer.MIN_VALUE ;
        int max2 = nums.length > 1 ? nums[1] : Integer.MIN_VALUE ;
        
        int i = 2;
        while( i < (nums.length-1) ){
            int newMax = nums[i] + Math.max( max1 , max2 - nums[i-1] ) ;
            max1 = max2;
            max2 = newMax;
            i++;
        }
        
        
        int max4 = nums.length > 0 ? nums[nums.length-1] : Integer.MIN_VALUE ;
        int max3 = nums.length > 1 ? nums[nums.length-2] : Integer.MIN_VALUE ;
        
        i = nums.length-3;
        while( i > 0 ){
            int newMax = nums[i] + Math.max( max4 , max3 - nums[i+1] ) ;
            max4 = max3;
            max3 = newMax;
            i--;
        }
       
        return Math.max( Math.max(max1,max2) , Math.max(max3,max4));
        
    }

}
