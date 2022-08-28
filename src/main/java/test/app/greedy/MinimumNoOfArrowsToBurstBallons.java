package test.app.greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

import test.app.utils.Utils;

public class MinimumNoOfArrowsToBurstBallons {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
		//System.out.println( Integer.MIN_VALUE);
		//System.out.println( Integer.MAX_VALUE);
		//System.out.println( System.in );
		//int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		//int[][] points = {{2,-1},{2,3}};
		
		//int[][] points = Utils.readLeetInput("leetinput");
		System.out.println( new MinimumNoOfArrowsToBurstBallons().findMinArrowShots(points));
	}
	
	
	public int findMinArrowShots(int[][] points) throws FileNotFoundException {
       
		
		/*
		 * All the time Spent in debug because I used wrong conditions in comparator.
		 */
        //Arrays.sort( points ,(p1,p2) -> p1[0] == p2[0] ? ( p2[1] < p1[1] ? -1 : 0) : ( p1[0] < p2[0]  ? -1 : 0) );
        
		Arrays.sort( points ,(p1,p2) -> Integer.compare(p1[0], p2[0]) );
		
        PrintStream o = new PrintStream(new File("leetdebug"));
        
        // Store current System.out
        // before assigning a new value
        PrintStream console = System.out;
 
        // Assign o to output stream
        // using setOut() method
        System.setOut(o);
        
        for ( int[] p : points )
        	System.out.println( Arrays.toString(p) );
        
        int arrows = 0;
        int end = points[0][1];
        for ( int i=1; i<points.length;i++ ) {
        	if( points[i][0] <= end ) {
        		end = Math.min(end, points[i][1]);
        		continue;
        	}
        	
        	arrows++;
        	end = points[i][1];
        }
        
        return arrows+1;
    }

	public int[][] getInput(){
		return null;
	}
}
