package test.app.priortyqueue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{3,3},{5,-1},{-2,4}};
		
		//18, 26, 20
		
		System.out.println( new KClosestPointsToOrigin().kClosest(points, 2));
	}
	
	
	public int[][] kClosest(int[][] points, int k) {
        
		//PriorityQueue<int[]> pq = new PriorityQueue<>( (a ,b) -> ( (a[0]*a[0] + a[1]*a[1] ) - (b[0]*b[0] + b[1]*b[1] ) ));
		
		PriorityQueue<int[]> pq = new PriorityQueue<>( (a ,b) -> ( (b[0]*b[0] + b[1]*b[1] ) - (a[0]*a[0] + a[1]*a[1] ) ));
		
		for (int[] point : points) {
			if( pq.size() == k) {
				int distanceFromOrigin = (point[0]*point[0] + point[1]*point[1] );
				int[] max = pq.peek();
				
				int temp = (max[0]*max[0] + max[1]*max[1] );
				
				if( distanceFromOrigin < temp ) {
					pq.remove();
					pq.add(point);
				}
			} else {
				pq.add(point);
			}
		}

		int[][] res = new int[k][2];
		int i=0;
		while( k-- > 0)
			res[i++] = pq.remove();
		
		return res;
    }

}
