package test.app.greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}
	
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[1],i2[1]));
        
        int end = intervals[0][1];
        int count = 0;
        for( int i=1 ; i<intervals.length; i++) {
        	if( intervals[i][0] < end ) {
        		count++;
        	} else
        		end = intervals[i][1];
        }
        
        return count;
        
   }

}
