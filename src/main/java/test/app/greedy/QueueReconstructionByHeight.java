package test.app.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int[][] reconstructQueue(int[][] people) {
		/*
		 * Before placing the person of height h at its location in output queue, we should ensure
		 * that all the person's having height greater than h has been processed because a later person with height greater than h could break k property of 
		 * already placed person in queue.
		 * 
		 * So it gives a hint we need to sort the people by their height h in decreasing order.
		 * Next Question : what if the height are equal ?
		 * Then we will use the k property to sort in increasing order.  
		 * 
		 * 
		 * Then we will process the people with greatest height first and so-on.
		 */
		
		
		Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]) ;
		
		List<int[]> output = new ArrayList<>();
		for( int[] p : people ) {
			output.add(p[1], p);
		}
		
		return output.toArray(new int[people.length][2]);
    }


}
