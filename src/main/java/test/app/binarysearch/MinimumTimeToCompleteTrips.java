package test.app.binarysearch;

import java.util.Arrays;
import java.util.stream.LongStream;

public class MinimumTimeToCompleteTrips {

	public static void main(String[] args) {
		System.out.println( new MinimumTimeToCompleteTrips().minimumTime(new int[] {10000}, 10000000));
	}
	
	public long minimumTime(int[] time, int totalTrips) {
        
		long min = Arrays.stream(time).min().getAsInt();
		
		long s=1,e=min*totalTrips;
        while( s <= e ){
        	long t = s + (e-s)/2l;
        	
        	
        	long trips = 0;
            for( int i=0;i<time.length;i++){
                 trips = trips + t/time[i];
            }
            
            if ( trips < totalTrips ) {
            	s = t+1;
            } else {
            	e = t-1;
            }
        }
        
        return s;
    }

}
