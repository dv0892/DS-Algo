package test.app.priortyqueue;

import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lastStoneWeight(int[] stones) {
	        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for ( int stone : stones ){
            pq.add(stone);
        }
        
        while( pq.size() > 1 ){
            int max1 = pq.remove();
            int max2 = pq.remove();
            
            if( max2 != max1 )
                pq.add( max1 - max2 );
        }
        
        return pq.peek() == null ? 0 : pq.remove();
	}

}
