package test.app.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int maxEventsOp1(int[][] events) {
        
		int N = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (e1,e2)->  e1[0]-e2[0] );

        int day = 0 , i=0;
        int count = 0;
        
        while( i<N || !pq.isEmpty() ) {
        	
        	if( pq.isEmpty() )
        	  day = events[i][0];
        	
        	// put all the events starting till this day into heap and then attend which is ending earliest
        	while( i<N && day==events[i][0] ) { 
        		pq.add(events[i][1]);
        		i++;
        	}
        	
        	pq.poll();
        	day++;
        	count++;
        	
        	// can't attend these events as they have ended.
        	while( !pq.isEmpty() && day > pq.peek() )
        		pq.poll();
        	
        }
        
        return count;
    }

	
	public int maxEvents(int[][] events) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)-> e1[0]==e2[0] ? e1[1]-e2[1] : e1[0]-e2[0] );
        for(int[] event : events )
            pq.add(event);
        
        Arrays.sort(events, (e1,e2)-> e1[0]==e2[0] ? e1[1]-e2[1] : e1[0]-e2[0]);

        int day = -1;
        int count = 0;
        while( !pq.isEmpty() ){
            int[] event = pq.remove();
            if( day > event[1] )
                continue;

            count++;
            if( day < event[0] )
                day = event[0]+1;
            else {
            	// We can also check if there is any other event whose starting time is this day and end time is least
            	// and its end time is lesser than event
                day++;
            }
        }

        return count;
    }
}
