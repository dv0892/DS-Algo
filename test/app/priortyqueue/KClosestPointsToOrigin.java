package test.app.priortyqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

import test.app.utils.Utils;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,3},{-2,2}};
		
		//18, 26, 20
		
		System.out.println( new KClosestPointsToOrigin().kClosestOptimized(points, 2));
	}
	
	
	public int[][] kClosest(int[][] points, int k) {
        
		// Time Complexity N.logk
		// Space Complexity O(k)
		
		// Can we do it better in Time O(N) and space O(1)
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
	
	
	public int[][] kClosestOptimized(int[][] points, int k) {
        
		// Time Complexity N.logk
		// Space Complexity O(k)
		
		// Can we do it better in Time O(N) and space O(1)
		int l=0 , r = points.length-1;
		k--;
				
	    while ( true ) {
	    	int p = parition(points,l,r);
	    	
	    	if( p == k )
	    		return Arrays.copyOf(points, k+1);
	    	
	    	if( p > k )
	    		r = p-1;
	    	else
	    		l = p+1;
	    }
	}


	private int parition(int[][] points, int l, int r) {
		// TODO Auto-generated method stub
		int i = l-1;
		int j = l;
		int random = r;
		int[] pivot = points[random];
		int pivotDistance = distance(pivot);
		
		while( j < r ) {
			if( distance(points[j]) <= pivotDistance ) {
				Utils.swap(points, ++i, j);
			}
			
			j++;
		}
		
		Utils.swap(points, i+1, r);
		
		return i+1;
		
	}
	
	public int distance( int[] point ) {
		return (point[0]*point[0] + point[1]*point[1] );
	}
}
