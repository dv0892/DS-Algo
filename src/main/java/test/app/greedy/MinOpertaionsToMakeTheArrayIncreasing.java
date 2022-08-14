package test.app.greedy;

import java.util.Arrays;

public class MinOpertaionsToMakeTheArrayIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minOperations(int[] nums) {
        int count = 0;
        for( int i=1;i<nums.length;i++){
            int diff = nums[i] - nums[i-1];
            
            if( diff < 1 ){
                count += (Math.abs(diff)+1);
                nums[i] = nums[i-1] + 1;
            }
        }
        
        return count;
    }

}
