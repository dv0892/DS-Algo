package test.app.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public long maximumImportance(int n, int[][] roads) {
		    
		 	long[] connectingRoads = new long[n];
	        for(int[] road : roads ){
	            connectingRoads[road[0]]++;
	            connectingRoads[road[1]]++;
	        } 
	        
	        
	        Arrays.sort(connectingRoads);
	        
	        long sum = 0; int i=1;
	        for(long c :  connectingRoads ){
	            sum += (long)(i++*c);
	        }
	        
	        // No Need for Priority Queue
	        
	        /*PriorityQueue<Long> pq = new PriorityQueue<>((c1,c2) -> Long.compare(c2,c1));
	        for(long c :  connectingRoads ){
	            pq.add(c);
	        } 
	        
	        long sum = 0;
	        while( !pq.isEmpty() ){
	            sum += (long)(n--*pq.remove());
	        }*/
	        
	        return sum;
	    }

}
