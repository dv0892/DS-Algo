package test.app.math;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import test.app.utils.Utils;

public class MinimumAverageDifference {

	int MOD = (int)(1e9+7);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MinimumAverageDifference().minimumAverageDifference(Utils.readLeetInput1("leetinput")));
		ExecutorService ex;
	}
	
    public int minimumAverageDifference(int[] nums) {
        long tSum = 0;
        for(int e : nums )
            tSum += e;

        long minAvgDiff = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        int n = nums.length;
        long runningSum = 0;
        
        System.out.println( " Total Sum  " + tSum );

        for(int i=0;i<n;i++){
            runningSum += nums[i];
            long avg1 = ( runningSum/(i+1) );
            long avg2 = ( Math.abs(tSum-runningSum)==0 ?  0 : ( Math.abs(tSum-runningSum)/(n-i-1) ) ) ;
            long avgDiff = Math.abs( avg1 - avg2 );

            if( avgDiff < minAvgDiff ){
                minAvgDiff = avgDiff;
                minIndex = i;
            }
        }

        return minIndex;
    }

}
