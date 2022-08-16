package test.app.greedy;

import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int fillCups(int[] amount) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((i,j) ->  j-i );
        pq.add(amount[0]); pq.add(amount[1]); pq.add(amount[2]);
     
        int count = 0;
        while(true){
            int m1 = pq.remove(), m2 = pq.remove();
            if ( m1==0 && m2==0 )
                break;
            
            pq.add(Math.max(0,--m1)); pq.add(Math.max(0,--m2));
            count++;
        }
        
        return count ;
        
    }

}
