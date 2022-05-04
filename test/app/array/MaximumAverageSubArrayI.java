package test.app.array;

import java.text.DecimalFormat;

public class MaximumAverageSubArrayI {

	public static void main(String[] args) {
		
		int[] nums = {5};
		System.out.println( new  MaximumAverageSubArrayI().findMaxAverage(nums, 1));
	}
	
	public double findMaxAverage(int[] nums, int k) {
        
		int sum = 0;
		for(int i=0;i<k;i++) {
			sum += nums[i];
		}
		
		double res = sum ;
		
		for(int i=k;i<nums.length;i++) {
			sum += ( nums[i] - nums[i-k] ) ;
			res = Math.max(res,sum);	
		}
		
		return res/k;
    }

}
