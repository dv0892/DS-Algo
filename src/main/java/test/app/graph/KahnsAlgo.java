package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class KahnsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes = 6;
		int[][] edges = { {1,0},{1,3},{1,5},
				          {3,4} , {5,4},
				          {0,2} , {3,0 },
				          {4,2}
				        };
		
	/*	int nodes = 2;
		int[][] edges = { {1,0},{0,1} };*/
		
		System.out.println( Arrays.toString( new KahnsAlgo().topologicalOrder(nodes, edges)) );
	
	}
	
	public int[] topologicalOrder( int n, int[][] edges ) {
		int[] order = new int[n];
		int[][] mat = new int[n][n];
		int[] indegree = new int[n];
		
		for ( int[] edge : edges ) {
			int src = edge[1];
			int dest = edge[0];
			
			mat[src][dest] = 1;
		    indegree[dest]++;
		}
		
		//Find all the zero in-degree nodes
		Deque<Integer> q = new LinkedList<>();
		for( int i=0;i<indegree.length;i++ ) {
			if( indegree[i] == 0 )
				q.add(i);
		}
		
		int i = 0;
		while( !q.isEmpty() ) {
			int node = q.remove();
			
			order[i++] = node;
			for ( int neigbhour=0; neigbhour<mat[node].length; neigbhour++) {
				if( mat[node][neigbhour] == 1 ) {
					indegree[neigbhour]--;
					
					if( indegree[neigbhour] <= 0 ) {
						q.add(neigbhour);
					}
				}
			}
			
			
		}
		if( i < n)
			return new int[0];
		
		return order;
	}

}
