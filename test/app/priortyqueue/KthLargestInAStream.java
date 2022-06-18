package test.app.priortyqueue;

import java.util.PriorityQueue;

public class KthLargestInAStream {
	public static void main( String... args) {
		
	}
}

class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->a-b);
        this.k = k;
        
        for(int num : nums){
            if( pq.size() < k ){
                pq.add(num);
            } else{
                if( num >= pq.peek() ){
                    pq.remove();
                    pq.add(num);
                }
            }
        }
        
        for ( Integer i : pq ) {
        	
        }
    }
    
    public int add(int num) {
         if( pq.size() < k ){
                pq.add(num);
            } else {
                if( num >= pq.peek() ){
                    pq.remove();
                    pq.add(num);
                }
            }
        
        return pq.peek();
    }
}
